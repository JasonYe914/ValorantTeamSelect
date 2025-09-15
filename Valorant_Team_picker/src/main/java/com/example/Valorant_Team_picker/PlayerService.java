package com.example.Valorant_Team_picker;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component //spring manages life cycle --> spring managed bean
public class PlayerService {
    @Autowired
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    //returns all the players in database
    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    //returns the players by name
    public List<Player> getPlayersByName(String name){
        //filters name checks even for lowercase
        return playerRepository.findAll().stream().filter(Player -> Player.getName().equals(name)
                || Player.getName().toLowerCase().equals(name)).collect(Collectors.toList());
    }

    //returns the players by team
    public List<Player> getPlayerByTeam(String text){
        return playerRepository.findAll().stream().filter(Player -> Player.getTeam().equals(text)
        || Player.getTeam().toLowerCase().equals(text)).collect(Collectors.toList());
    }

    //get players by agent
    public List<Player> getPlayersByAgent(String text){
        return playerRepository.findAll().stream().filter(Player -> Player.getAgent().equals(text)
                || Player.getAgent().toLowerCase().equals(text)).collect(Collectors.toList());
    }

    //get player by acs
    public List<Player> getPlayersByAcs(Float num){
        return playerRepository.findAll().stream().filter(Player -> Player.getAcs().equals(num) ||
                Player.getAcs() > num).collect(Collectors.toList());
    }

    //get player by KD
    public List<Player> getPlayersByKD(Float num){
        return playerRepository.findAll().stream().filter(Player -> Player.getKd() >= num).
                collect(Collectors.toList());

    }

    //add new player in database
    public Player addPlayer(Player player){
        if(!playerRepository.findByName(player.getName()).isPresent()){
            playerRepository.save(player);
        }
        return player;
    }

    //update player in database
    public Player updatePlayer(Player player){
        if(playerRepository.findByName(player.getName()).isPresent()){
            Player updatedPlayer = playerRepository.findByName(player.getName()).get();
            updatedPlayer.setName(player.getName());
            updatedPlayer.setTeam(player.getTeam());
            updatedPlayer.setAcs(player.getAcs());
            updatedPlayer.setKd(player.getKd());
            updatedPlayer.setK(player.getK());
            updatedPlayer.setD(player.getD());
            updatedPlayer.setA(player.getD());
            playerRepository.save(updatedPlayer);
        }
        return updatePlayer(player);
    }

    //deletes the player
    @Transactional
    public void deletePlayer(String name){
        playerRepository.deleteByName(name);
    }




}
