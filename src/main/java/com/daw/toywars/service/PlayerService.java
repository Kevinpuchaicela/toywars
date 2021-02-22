package com.daw.toywars.service;

import com.daw.toywars.data.Player.Player;
import com.daw.toywars.data.puppets.Puppet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    public List<Player> playerList = new ArrayList<>();

    public Player login(Player player) {
        String inputEmail = player.getEmail();
        String inputPassword = player.getPassword();

        for (Player existingPlayer : playerList) {
            if (existingPlayer.getEmail().equals(inputEmail) && existingPlayer.getPassword().equals(inputPassword)) {
                return existingPlayer;
            }
        }
        return null;
    }

    public Player register(Player player) {
        playerList.add(player); // TODO: Por qué quitar el "this" no da ERROR?? Revisar.
        return player;
    }

    public boolean checkIfPlayerExist(Player player) {
        for (Player existingPlayer : playerList) {
            if (existingPlayer.getEmail().equals(player.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public Player findPlayer(String id) {
        for (Player existingPlayer : playerList) {
            if (existingPlayer.getId().equals(id)) {
                return existingPlayer;
            }
        }
        return null;
    }

    public Puppet findPuppet(String id) {
        for (Player existingPlayer : playerList) {
            for (Puppet existingPuppet : existingPlayer.getPuppets()) {
                if (existingPuppet.getId().equals(id)) {
                    return existingPuppet;
                }
            }
        }
        return null;
    }


    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
