import { useState } from "react";
import "./App.css"; // make sure App.css is in the same folder as App.js
import "./index.css"; 

function App() {
  const [searchTerm, setSearchTerm] = useState("");
  const [searchField, setSearchField] = useState("name");
  const [results, setResults] = useState([]);
  const [team, setTeam] = useState([]);

  const handleSearch = async () => {
    if (searchTerm.trim() === "") {
      setResults([]);
      return;
    }

    const url = `http://localhost:7070/api/v1/vl/search?${searchField}=${encodeURIComponent(
      searchTerm
    )}`;

    try {
      const res = await fetch(url);
      const data = await res.json();
      setResults(data);
    } catch (err) {
      console.error("Error fetching players:", err);
    }
  };

  const addToTeam = (player) => {
    if (team.length >= 5) {
      alert("Team is full! (Max 5 players)");
      return;
    }
    if (team.find((p) => p.id === player.id)) {
      alert("Player already in team!");
      return;
    }
    setTeam([...team, player]);
  };

  const removeFromTeam = (id) => {
    setTeam(team.filter((p) => p.id !== id));
  };

  return (
    <div className="app">
      {/* Header */}
      <header className="header">
        <h1>Valorant Fantasy Draft</h1>
      </header>

      <main className="main">
        {/* Left: Search + Results */}
        <div className="search-section">
          <div className="search-bar">
            <select
              value={searchField}
              onChange={(e) => setSearchField(e.target.value)}
            >
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

          {/* Results */}
          <div className="results">
            {results.length === 0 && searchTerm !== "" && (
              <p className="no-results">No players found.</p>
            )}

            {results.map((player) => (
              <div key={player.id} className="player-card">
                <h2>{player.name}</h2>
                <p>Team: {player.team}</p>
                <p>Agent: {player.agent}</p>
                <p>ACS: {player.acs}</p>
                <p>KD: {player.kd}</p>
                <button onClick={() => addToTeam(player)}>Add to Team</button>
              </div>
            ))}
          </div>
        </div>

        {/* Right: Fantasy Team */}
        <div className="team-section">
          <h2>My Fantasy Team</h2>
          {team.length === 0 && (
            <p className="empty-team">No players selected yet.</p>
          )}
          <ul>
            {team.map((player) => (
              <li key={player.id} className="team-player">
                <span>{player.name}</span>
                <button onClick={() => removeFromTeam(player.id)}>Remove</button>
              </li>
            ))}
          </ul>
          {team.length === 5 && <p className="team-ready">Team is ready!</p>}
        </div>
      </main>
    </div>
  );
}

export default App;
