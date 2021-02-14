package com.daw.toywars.controller;

import com.daw.toywars.data.puppets.pokemons.PokemonType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToyWarsController {
    @PostMapping("/new")
    public String puppet(@RequestParam String name, @RequestParam PokemonType pokemonType, @RequestParam String color, Model model){
        model.addAttribute("name", name);
        model.addAttribute("pokemonType",pokemonType);
        model.addAttribute("color", color);
        return "index";
    }
}
