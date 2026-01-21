import { useEffect, useRef } from "react";
import { getDistanceMeter } from "../utils/distance";

declare global {
  interface Window {
    naver: any;
  }
}

function NaverMap() {
  const mapRef = useRef<any>(null);

  useEffect(() => {
    // =========================
    // 1️⃣ 지도 생성
    // =========================
    const map = new window.naver.maps.Map("map", {
      center: new window.naver.maps.LatLng(37.5665, 126.9780), // 임시 중심 (서울시청)
      zoom: 15,
    });

    mapRef.current = map;

    // =========================
    // 2️⃣ 내 위치 가져오기 (1회)
    // =========================
    navigator.geolocation.getCurrentPosition(
      (position) => {
        const myLat = position.coords.latitude;
        const myLng = position.coords.longitude;

        // 내 위치 마커
        const myPosition = new window.naver.maps.LatLng(myLat, myLng);

        new window.naver.maps.Marker({
          position: myPosition,
          map: map,
          icon: {
            content: `<div style="
              width:14px;
              height:14px;
              background:#007aff;
              border-radius:50%;
              border:2px solid white;
            "></div>`,
          },
        });

        map.setCenter(myPosition);

        // =========================
        // 3️⃣ 백엔드에서 화장실 목록 가져오기
        // =========================
        fetch("http://localhost:8080/api/restrooms")
          .then((res) => res.json())
          .then((restrooms) => {
            // =========================
            // 4️⃣ 거리 계산 + 가까운 순 정렬
            // =========================
            const restroomsWithDistance = restrooms.map((r: any) => ({
              ...r,
              distance: getDistanceMeter(
                myLat,
                myLng,
                r.lat,
                r.lng
              ),
            }));

            restroomsWithDistance.sort(
              (a: any, b: any) => a.distance - b.distance
            );

            console.log("가까운 순 화장실:", restroomsWithDistance);

            // =========================
            // 5️⃣ 화장실 마커 생성
            // =========================
            restroomsWithDistance.forEach((r: any, index: number) => {
              const position = new window.naver.maps.LatLng(r.lat, r.lng);

              const marker = new window.naver.maps.Marker({
                position,
                map,
                title: r.name,
                icon:
                  index === 0
                    ? {
                        // 가장 가까운 화장실 (강조)
                        content: `<div style="
                          background:#ff3b30;
                          color:white;
                          padding:4px 6px;
                          border-radius:6px;
                          font-size:12px;
                          font-weight:bold;
                        ">🚻 가장 가까움</div>`,
                      }
                    : undefined,
              });

              const infoWindow = new window.naver.maps.InfoWindow({
                content: `
                  <div style="padding:8px;font-size:13px;">
                    🚻 <b>${r.name}</b><br/>
                    거리: ${Math.round(r.distance)} m<br/>
                    ${r.open24h ? "24시간 이용 가능" : "운영시간 제한"}
                  </div>
                `,
              });

              window.naver.maps.Event.addListener(marker, "click", () => {
                infoWindow.open(map, marker);
              });
            });
          });
      },
      (error) => {
        console.error("위치 가져오기 실패", error);
        alert("위치 권한을 허용해야 서비스를 이용할 수 있습니다.");
      },
      {
        enableHighAccuracy: true,
      }
    );
  }, []);

  return (
    <div
      id="map"
      style={{ width: "100%", height: "100vh" }}
    />
  );
}

export default NaverMap;
