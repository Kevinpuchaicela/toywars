package com.daw.toywars.controller;

import com.daw.toywars.data.Player.Player;
import com.daw.toywars.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class PlayerRestController {
    PlayerService playerService;

    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("player/{id}")
    public Player getPlayer(@PathVariable String id) {
        return playerService.findPlayer(id);
    }

    @GetMapping("players")
    public List<Player> getPlayers() {
        return playerService.getPlayerList();
    }

    @PostMapping("/register")
    public Player createPlayer(@ModelAttribute Player player) {
        if (playerService.checkIfPlayerExist(player)) {
            return null; //HttpStatus.BAD_REQUEST
        }
        return playerService.register(player); // OR playerService.getCurrentPlayer. L28.
    }

    @PostMapping("/login")
    public Player login(@ModelAttribute Player player) {
        return playerService.login(player);
    }
//    @GetMapping("/player")
//    public Player getPlayer(){
//        return playerService.getCurrentPlayer();
//    }
}



