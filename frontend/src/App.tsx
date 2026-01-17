import NaverMap from "./components/NaverMap";

function App() {
  return (
    <div style={{ padding: 40 }}>
      <h1>Public Restrooms</h1>

      <p style={{ marginTop: 10, color: "#555" }}>
        내 주변 공공화장실을 지도로 확인하세요
      </p>

      <NaverMap />
    </div>
  );
}

export default App;
