package com.daw.toywars.data.puppets.pokemons;

import com.daw.toywars.data.*;
import org.apache.commons.lang3.StringUtils;

public class Pokemon extends LifeBeing implements IActions, IRender {
    private String name;
    private PokemonType pokemonType;
    private String colorType;
    private Status status;

    public Pokemon(String name, PokemonType pokemonType, String colorType, Status status) {
        this.name = name;
        this.pokemonType = pokemonType;
        this.colorType = colorType;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(PokemonType pokemonType) {
        this.pokemonType = pokemonType;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    @Override
    public void doFeed() {
        System.out.println("Pokemon comiendo...");
        this.status.setHealthPoints(getStatus().getHealthPoints() + 5);
    }

    @Override
    public void doCleanIt() {
        System.out.println("Pokemon limpiandose...");
    }

    @Override
    public void doWalk() {
        System.out.println("Pokemon caminando...");

    }

    @Override
    public void doPlay() {
        System.out.println("Pokemon jugando...");
    }

    @Override
    public void doSleep() {
        System.out.println("Pokemon durmiendo...");
    }

    @Override
    public void doFight() {
        this.status.setHealthPoints(getStatus().getHealthPoints() - 50);
    }

    @Override
    public void doReset() {
    }

    @Override
    public void doDie() {
        System.out.println("El pokemon ha muerto");
    }


    @Override
    public String doRender(RenderType renderType) {
        String rtn = StringUtils.EMPTY;
        switch (renderType) {
            case CONSOLE:
                System.out.println(String.format("POKE: %s", "Pikachu"));
                break;
            case HTML:
                rtn = String.format("<div>%s</div>", "Charizard");
                return rtn;
            default:
                //rtn=JSONObject.toJSONString();
                break;
        }
        return null;
    }
}
