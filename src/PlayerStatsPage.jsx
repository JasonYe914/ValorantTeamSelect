// src/PlayerStatsPage.jsx
import { useEffect, useState } from "react";

const API_BASE = "http://localhost:7070/api/v1/vl";

export default function PlayerStatsPage() {
  const [players, setPlayers] = useState([]);

  useEffect(() => {
    const fetchPlayers = async () => {
      try {
        const res = await fetch(`${API_BASE}/search`);
        const data = await res.json();
        setPlayers(data);
      } catch (err) {
        console.error("Error fetching player stats:", err);
      }
    };

    fetchPlayers();
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>All Player Stats</h1>
      <table border="1" cellPadding="8" style={{ borderCollapse: "collapse", width: "100%" }}>
        <thead>
          <tr>
            <th>Name</th>
            <th>Team</th>
            <th>Agent</th>
            <th>ACS</th>
            <th>KD</th>
          </tr>
        </thead>
        <tbody>
          {players.map((p) => (
            <tr key={p.id}>
              <td>{p.name}</td>
              <td>{p.team}</td>
              <td>{p.agent}</td>
              <td>{p.acs}</td>
              <td>{p.kd}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
