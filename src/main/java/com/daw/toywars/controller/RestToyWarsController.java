package com.daw.toywars.controller;

import com.daw.toywars.data.*;
import com.daw.toywars.data.Player.Player;
import com.daw.toywars.data.puppets.Puppet;
import com.daw.toywars.data.puppets.pokemons.Pokemon;
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

    @GetMapping("do/{action}/{idPuppet}")
    public List<UserAction> doAction(@PathVariable Action action , @PathVariable String idPuppet) {
        gameService.setCurrentPuppet(playerService.findPuppet(idPuppet));
        gameService.doAction(action);
        return getStats();
        //do/FEED
    }

    @GetMapping("/get/CurrentStatus/{id}")
    public Status getCurrentStatus(@PathVariable String id) {
        return playerService.findPuppet(id).getStatus();
    }
    @GetMapping("/get/puppet/{id}")
    public Puppet getPuppet(@PathVariable String id) {
        return playerService.findPuppet(id);
    }

    @GetMapping("/get/Stats")
    public List<UserAction> getStats() {
        return gameService.getUserActions();
    }

    @GetMapping("/render/{mode}/{id}")
    public String getRender(@PathVariable RenderType mode, @PathVariable String id) {
        gameService.setCurrentPuppet(playerService.findPuppet(id));
        return gameService.render(mode);
    }

    @PostMapping("/new/pokemon")
    public Puppet createNewPoke(@ModelAttribute Pokemon pokemon, String id) {
        gameService.createNewPokemon(pokemon);
        playerService.findPlayer(id).addPuppet(gameService.getCurrentPuppet()); //seteamos el puppet al player
        return gameService.getCurrentPuppet();

    }

    @PostMapping("/new/tamagochi")
    public Puppet createNewTama(@ModelAttribute Tamagochi tamagochi, Player player) {
        gameService.createNewTamagochi(tamagochi);
        playerService.findPlayer(player.getId()).addPuppet(gameService.getCurrentPuppet());//seteamos el puppet al player
        return gameService.getCurrentPuppet();
    }

    @GetMapping("/getActions")
    public Action[] getActions() {
        return Action.values();
    }

    @GetMapping("/getCurrentPuppet")
    public Puppet getCurrentPuppet() {
        return gameService.getCurrentPuppet();
    }
}
