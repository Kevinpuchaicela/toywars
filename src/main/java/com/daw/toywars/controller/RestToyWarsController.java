package com.daw.toywars.controller;

import com.daw.toywars.data.*;
import com.daw.toywars.data.puppets.pokemons.Pokemon;
import com.daw.toywars.data.puppets.pokemons.PokemonType;
import com.daw.toywars.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class RestToyWarsController {
    GameService gameService;

    public RestToyWarsController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("do/{action}")
    public List<UserAction> doAction(@PathVariable Action action) {
        gameService.doAction(action);
        return getStats();
    }

    //    @RequestMapping(value = "/get/{uuid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Player>>getRegisterById(@PathVariable UUID uuid) {
//        try {
//            return new ResponseEntity<>(analysisService.getDataRegisterById(uuid), HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("register:get/", e);
//            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
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

    @PostMapping("/new")
    public LifeBeing createNewPuppet(@RequestParam String name, @RequestParam PokemonType pokemonType, @RequestParam String color) {
        LifeBeing pikachu = new Pokemon(name, pokemonType, color, new Status());
        gameService.setCurrentLifeBeing(pikachu);
        gameService.resetLifeBeing();
        return gameService.getCurrentLifeBeing();
    }

    @GetMapping("/getActions")
    public Action[] getActions() {
        return Action.values();
    }
    @GetMapping("/getCurrentPuppet")
    public LifeBeing getCurrentPuppet(){
        return gameService.getCurrentLifeBeing();
    }
}
