// src/App.jsx
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import SearchPage from "./SearchPage";
import PlayerStatsPage from "./PlayerStatsPage";
import "./App.css";
import "./index.css";

export default function App() {
  return (
    <Router>
      {/* Navigation bar */}
      <nav style={{ padding: "10px", background: "#222", color: "#fff" }}>
        <Link to="/" style={{ marginRight: "20px", color: "#fff" }}>
          Team Selection
        </Link>
        <Link to="/stats" style={{ color: "#fff" }}>
          Player Stats
        </Link>
      </nav>

      {/* Routes */}
      <Routes>
        <Route path="/" element={<SearchPage />} />
        <Route path="/stats" element={<PlayerStatsPage />} />
      </Routes>
    </Router>
  );
}
