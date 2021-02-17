package com.daw.toywars.controller;

import com.daw.toywars.data.*;
import com.daw.toywars.data.puppets.PuppetType;
import com.daw.toywars.data.puppets.pokemons.Pokemon;
import com.daw.toywars.data.puppets.pokemons.PokemonType;
import com.daw.toywars.data.puppets.tamagochi.Tamagochi;
import com.daw.toywars.service.GameService;
import com.daw.toywars.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class RestToyWarsController {
    GameService gameService;
    PlayerService playerService;

    public RestToyWarsController(GameService gameService, PlayerService playerService) {
        this.gameService = gameService;
        this.playerService = playerService;
    }

    @GetMapping("do/{action}")
    public List<UserAction> doAction(@PathVariable Action action) {
        gameService.doAction(action);
        return getStats();
        //do/FEED
    }

    @GetMapping("/get/CurrentStatus")
    public Status getCurrentStatus() {
        return gameService.getCurrentLifeBeing().getStatus();
    }

    @GetMapping("/get/Stats")
    public List<UserAction> getStats() {
        return gameService.getUserActions();
    }

    @GetMapping("/render/{mode}")
    public void getRender(@PathVariable RenderType mode) {
        gameService.render(mode);
    }

    @PostMapping("/new/pokemon")
    public LifeBeing createNewPoke(@ModelAttribute Pokemon pokemon) {
        gameService.createNewPokemon(pokemon);
        playerService.getCurrentPlayer().addPuppet(gameService.getCurrentLifeBeing()); //seteamos el puppet al player
        return gameService.getCurrentLifeBeing();

    }

    @PostMapping("/new/tamagochi")
    public LifeBeing createNewTama(@ModelAttribute Tamagochi tamagochi) {
        gameService.createNewTamagochi(tamagochi);
        playerService.getCurrentPlayer().addPuppet(gameService.getCurrentLifeBeing()); //seteamos el puppet al player
        return gameService.getCurrentLifeBeing();
    }

    @GetMapping("/getActions")
    public Action[] getActions() {
        return Action.values();
    }

    @GetMapping("/getCurrentPuppet")
    public LifeBeing getCurrentPuppet() {
        return gameService.getCurrentLifeBeing();
    }
}
