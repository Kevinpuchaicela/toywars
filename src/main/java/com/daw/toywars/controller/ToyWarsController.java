package com.daw.toywars.controller;

import com.daw.toywars.data.Player.Player;
import com.daw.toywars.data.puppets.pokemons.Pokemon;
import com.daw.toywars.data.puppets.tamagochi.Tamagochi;
import com.daw.toywars.service.GameService;
import com.daw.toywars.service.PlayerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToyWarsController {
    PlayerService playerService;
    GameService gameService;

    public ToyWarsController(PlayerService playerService, GameService gameService) {
        this.playerService = playerService;
        this.gameService = gameService;
    }

    public String redirectHome() {
        return "redirect:/";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/register")
    public String registerAccount(@ModelAttribute Player player) {
        return "createAccount";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
