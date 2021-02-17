package com.daw.toywars.controller;

import com.daw.toywars.data.Player.Player;
import com.daw.toywars.service.PlayerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class PlayerRestController {
    PlayerService playerService;

    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/register")
    public Player createPlayer(@ModelAttribute Player player) {
        playerService.register(player);
        return getPlayer(); // OR playerService.getCurrentPlayer. L28.
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



/*
package com.daw.toywars.controller;

import com.daw.toywars.data.Player.Player;
import com.daw.toywars.service.PlayerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class PlayerRestController {
    PlayerService playerService;

    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/register")
    public Player createPlayer(@ModelAttribute Player player) {
        playerService.register(player);
        return getPlayer(); // OR playerService.getCurrentPlayer. L28.
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
* */
