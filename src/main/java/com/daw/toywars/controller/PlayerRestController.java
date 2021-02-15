package com.daw.toywars.controller;

import com.daw.toywars.data.Player.Player;
import com.daw.toywars.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerRestController {
    PlayerService playerService;

    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/createAccount")
    public Player createPlayer(@ModelAttribute Player player) {
        playerService.register(player);
        return player;
    }

    @PostMapping("/login")
    public boolean login(@ModelAttribute Player player) {
        return playerService.login(player);
    }
    @GetMapping("/player")
    public Player getPlayer(){
        return playerService.getCurrentPlayer();
    }
}
