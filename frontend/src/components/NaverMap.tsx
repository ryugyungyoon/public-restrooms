import { useEffect, useRef } from "react";

declare global {
  interface Window {
    naver: any;
  }
}

function NaverMap() {
  const mapRef = useRef<any>(null);
  const markerRef = useRef<any>(null);
  const watchIdRef = useRef<number | null>(null);
  const isFirstFixRef = useRef(true); // ⭐ 핵심

  useEffect(() => {
    const mapDiv = document.getElementById("map");
    if (!mapDiv || !window.naver) return;

    // 1. 지도 생성
    mapRef.current = new window.naver.maps.Map(mapDiv, {
      center: new window.naver.maps.LatLng(37.5665, 126.9780),
      zoom: 15,
    });

    // ===============================
    // 2. 화장실 마커는 여기!
    // ===============================
  /*  const restroomLatLng = new window.naver.maps.LatLng(37.5658, 126.9770);

    const restroomMarker = new window.naver.maps.Marker({
      position: restroomLatLng,
      map: mapRef.current,
      title: "공공화장실",
    });

    // 정보창
    const infoWindow = new window.naver.maps.InfoWindow({
      content: `
        <div style="padding:8px;font-size:13px;">
          🚻 <b>공공화장실</b><br/>
          24시간 이용 가능
        </div>
      `,
    });

    window.naver.maps.Event.addListener(restroomMarker, "click", () => {
      infoWindow.open(mapRef.current, restroomMarker);
    });*/

    fetch("http://localhost:8080/api/restrooms")
      .then(res => res.json())
      .then((restrooms) => {
        restrooms.forEach((restroom: any) => {
          const position = new window.naver.maps.LatLng(
            restroom.lat,
            restroom.lng
          );

          const marker = new window.naver.maps.Marker({
            position,
            map: mapRef.current,
            title: restroom.name,
          });

          const infoWindow = new window.naver.maps.InfoWindow({
            content: `
              <div style="padding:8px;font-size:13px;">
                🚻 <b>${restroom.name}</b><br/>
                ${restroom.open24h ? "24시간 이용 가능" : "운영시간 제한"}
              </div>
            `,
          });

          window.naver.maps.Event.addListener(marker, "click", () => {
            infoWindow.open(mapRef.current, marker);
          });
        });
      })
      .catch(err => {
        console.error("API 호출 실패:", err);
      });


    // ===============================
    // 3. 그 다음에 GPS watchPosition
    // ===============================
    watchIdRef.current = navigator.geolocation.watchPosition(
      (position) => {
        const { latitude, longitude } = position.coords;
        const currentLatLng = new window.naver.maps.LatLng(latitude, longitude);

        // 마커는 계속 이동
        if (!markerRef.current) {
          markerRef.current = new window.naver.maps.Marker({
            position: currentLatLng,
            map: mapRef.current,
            title: "내 위치",
          });
        } else {
          markerRef.current.setPosition(currentLatLng);
        }

        // ⭐ 최초 1회만 지도 중심 이동
        if (isFirstFixRef.current) {
          mapRef.current.setCenter(currentLatLng);
          isFirstFixRef.current = false;
        }
      },
      (error) => console.error(error),
      {
        enableHighAccuracy: true,
        maximumAge: 0,
      }
    );

    return () => {
      if (watchIdRef.current !== null) {
        navigator.geolocation.clearWatch(watchIdRef.current);
      }
    };
  }, []);

  return <div id="map" style={{ width: "100%", height: "500px" }} />;
}

export default NaverMap;
