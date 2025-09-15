package com.example.Valorant_Team_picker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//uses RESTful API
@RequestMapping(path="/api/v1/vl") //maps to json
public class PlayerController {

    //initialize the playerservice
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    //get http operations
    @GetMapping("/search")
    public List<Player> getPlayers(@RequestParam (required = false) String name,
                                   @RequestParam (required = false) String team,
                                   @RequestParam (required = false) String agent,
                                   @RequestParam (required = false) Float acs,
                                   @RequestParam (required = false) Float kd){
        if(name != null){
            return playerService.getPlayersByName(name); //return stuff based on param
        }
        else if(team != null){
            return playerService.getPlayerByTeam(team);
        }
        else if(agent != null){
            return playerService.getPlayersByAgent(agent);
        }
        else if(acs != null){
            return playerService.getPlayersByAcs(acs);
        }
        else if(kd != null){
            return playerService.getPlayersByKD(kd);
        }
        else{
            return playerService.getPlayers();
        }

    }

    //post http operations
    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player){
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED); //response
    }

    //put/update http operations
    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player updatedPlayer = playerService.updatePlayer(player);
        return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
    }

    //delete http operations
    @DeleteMapping
    public ResponseEntity<Player> deletePlayer(@PathVariable String name){
        playerService.deletePlayer(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
