package com.daw.toywars.data.puppets.pokemons;

import com.daw.toywars.data.*;
import org.apache.commons.lang3.StringUtils;

public class Pokemon extends LifeBeing implements IActions, IRender {
    private PokemonType pokemonType;

    public Pokemon(String name, String colorType, Status status, PokemonType pokemonType) {
        super(name, colorType, status);
        this.pokemonType = pokemonType;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(PokemonType pokemonType) {
        this.pokemonType = pokemonType;
    }

    // pasar el metodo al LifeBeing o incluso crar una clase Toy extendiendo de LifeBeing y ponerlo ahí?.
    public Integer getCurrentOption(String option) {
        switch (option) {
            case "vida":
                return super.getStatus().getHealthPoints();
            case "exp":
                return super.getStatus().getExperiencePoints();
            default:
                return null;
        }
    }

    @Override
    public void doFeed() {
        final Integer pointsForEating = 10;
//        el pokemon cada vez que coma aumentará la vida 10p, si a la hora de comer la vida sobrepasa 145 vomitará (porque está lleno)
//        y se le restará 25 de vida.
        if ((getStatus().getHealthPoints() + pointsForEating) > 145) {
            Status status = new Status(getCurrentOption("vida") - 25, getCurrentOption("exp"));
            super.setStatus(status);
            System.out.println("Pokemon vomitando...");
        } else {
            System.out.println("Pokemon comiendo...");
//        +10 de vida
            Status status = new Status(getCurrentOption("vida") + pointsForEating, getCurrentOption("exp"));
            super.setStatus(status);
        }

        //doRender(RenderType.HTML);

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
//        this.status.setHealthPoints(getStatus().getHealthPoints() - 50);
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
                rtn = String.format("<div>%s</div>", getName());
                return rtn;
            default:
                //rtn=JSONObject.toJSONString();
                break;
        }
        return null;
    }
}
