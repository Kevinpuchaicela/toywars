package com.daw.toywars.service;

import com.daw.toywars.data.Player.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    public List<Player> playerList = new ArrayList<>();
    public Player currentPlayer;


    public boolean login(Player player) {
        String inputEmail = player.getEmail();
        String inputPassword = player.getPassword();

        for (Player existingPlayer : playerList) {
            if (existingPlayer.getEmail().equals(inputEmail) && existingPlayer.getPassword().equals(inputPassword)) {
                setCurrentPlayer(existingPlayer);
                return true;
            }
        }
        return false;

    }

    public void register(Player player){
        setCurrentPlayer(player);
       this.playerList.add(player);
    }


    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
