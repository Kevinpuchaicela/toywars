package com.daw.toywars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToyWarsController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/createNewPuppet")
    public String createNewPuppet() {
        return "createPuppet";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/rest/createNew/pokemon")
    public String viewPoke() {
        return "index";
    }

    @GetMapping("/rest/createNew/tamagochi")
    public String viewTama() {
        return "index";
    }
}
