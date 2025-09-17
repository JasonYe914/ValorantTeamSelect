import { useState } from "react";
const API_BASE = "http://localhost:7070/api/v1/vl";

export default function SearchPage() {
  const [searchTerm, setSearchTerm] = useState("");
  const [searchField, setSearchField] = useState("name");
  const [results, setResults] = useState([]);
  const [team, setTeam] = useState([]);

  const handleSearch = async () => {
    if (!searchTerm.trim()) return setResults([]);
    try {
      const res = await fetch(`${API_BASE}/search?${searchField}=${encodeURIComponent(searchTerm)}`);
      const data = await res.json();
      setResults(data);
    } catch (err) {
      console.error(err);
    }
  };

  const addToTeam = (player) => {
    if (team.length >= 5) return alert("Team full!");
    if (team.find((p) => p.id === player.id)) return alert("Already added!");
    setTeam([...team, player]);
  };

  const removeFromTeam = (id) => setTeam(team.filter((p) => p.id !== id));

  return (
    <div className="page-container">
      <div className="search-team-layout">
        {/* Left: Search + Results */}
        <div className="left-panel">
          <div className="search-bar">
            <select value={searchField} onChange={(e) => setSearchField(e.target.value)}>
              <option value="name">Name</option>
              <option value="team">Team</option>
              <option value="agent">Agent</option>
              <option value="acs">ACS</option>
              <option value="kd">KD</option>
            </select>
            <input
              type="text"
              placeholder={`Search by ${searchField}...`}
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
              onKeyDown={(e) => e.key === "Enter" && handleSearch()}
            />
            <button onClick={handleSearch}>Search</button>
          </div>

          <div className="results-grid">
            {results.map((player) => (
              <div key={player.id} className="player-card">
                <h3>{player.name}</h3>
                <p><strong>Team:</strong> {player.team}</p>
                <p><strong>Agent:</strong> {player.agent}</p>
                <p><strong>ACS:</strong> {player.acs}</p>
                <p><strong>KD:</strong> {player.kd}</p>
                <button className="add-btn" onClick={() => addToTeam(player)}>Add</button>
              </div>
            ))}
          </div>
        </div>

        {/* Right: Fantasy Team */}
        <div className="right-panel team-section">
          <h2>My Fantasy Team</h2>
          {team.length === 0 && <p>No players yet.</p>}
          <ul className="team-list">
            {team.map((p) => (
              <li key={p.id}>
                {p.name} <button onClick={() => removeFromTeam(p.id)}>Remove</button>
              </li>
            ))}
          </ul>
          {team.length === 5 && <p>Team is ready!</p>}
        </div>
      </div>
    </div>
  );
}
