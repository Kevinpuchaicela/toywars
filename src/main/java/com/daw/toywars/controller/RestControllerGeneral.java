package com.daw.toywars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
//TODO: buscar el método que nos permite crear una "raíz" estática.
public class RestControllerGeneral {
    private static final String template = "/";
    @RequestMapping(value = "/get/{uuid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Player>>getRegisterById(@PathVariable UUID uuid) {
        try {
            return new ResponseEntity<>(analysisService.getDataRegisterById(uuid), HttpStatus.OK);
        } catch (Exception e) {
            log.error("register:get/", e);
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get/CurrentStatus")
    public void getCurrentStatus() {

    }
    @GetMapping("/get/Stats")
    public  void getStats(){

    }
    @GetMapping("/render")
    public  void getRender(){

    }
    @GetMapping("/new")
    public  void getNewPuppet(){

    }
    @GetMapping("/getActions")
    public  void getActions(){

    }
}
