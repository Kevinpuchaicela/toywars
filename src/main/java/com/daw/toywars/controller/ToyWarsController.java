package com.daw.toywars.controller;

import com.daw.toywars.data.Player.Player;
import com.daw.toywars.data.puppets.pokemons.Pokemon;
import com.daw.toywars.data.puppets.tamagochi.Tamagochi;
import com.daw.toywars.service.GameService;
import com.daw.toywars.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.swing.text.View;

@Controller
public class ToyWarsController {
    PlayerService playerService;
    GameService gameService;

    public ToyWarsController(PlayerService playerService, GameService gameService) {
        this.playerService = playerService;
        this.gameService = gameService;
    }

    public String redirectHome(){
        return "redirect:/";
    }

    @GetMapping("/")
    public String index() {
        if (playerService.getCurrentPlayer() == null) {
            return "login";
        }
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
        if (!(playerService.getCurrentPlayer() == null)) {
            return index();
        }
        return "login";

    }

    /* POST FORMS */

    @PostMapping("/register")
    public String registerPost(@ModelAttribute Player player) {
        playerService.register(player);
        return "redirect:/"; // Al usar index() funciona pero en la URL sigue poniendo /register
    }

    @PostMapping("/new/pokemon")
    public String viewPoke(@ModelAttribute Pokemon pokemon) {
        gameService.createNewPokemon(pokemon);
        playerService.getCurrentPlayer().addPuppet(gameService.getCurrentLifeBeing());
        return redirectHome();
    }

    @PostMapping("/new/tamagochi")
    public String viewTama(@ModelAttribute Tamagochi tamagochi) {
        gameService.createNewTamagochi(tamagochi);
        playerService.getCurrentPlayer().addPuppet(gameService.getCurrentLifeBeing());
        return redirectHome();
    }
}
