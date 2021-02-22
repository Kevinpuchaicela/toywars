package com.daw.toywars.data.puppets.pokemons;

import com.daw.toywars.data.*;
import com.daw.toywars.data.puppets.AsciiArt;
import com.daw.toywars.data.puppets.GifArt;
import com.daw.toywars.data.puppets.Puppet;
import com.daw.toywars.data.utils.DelayUtil;

public class Pokemon extends Puppet {
    private PokemonType pokemonType;

    public Pokemon(String name, String colorType, PokemonType pokemonType) {
        super(name, colorType);
        this.pokemonType = pokemonType;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(PokemonType pokemonType) {
        this.pokemonType = pokemonType;
    }


    //HELPERS
    // pasar el metodo al Puppet o incluso crar una clase Toy extendiendo de Puppet y ponerlo ahí?.
    public Integer getCurrentOption(String option) {
        switch (option) {
            case "health":
                return super.getStatus().getHealth();
            case "coins":
                return super.getStatus().getCoins();
            case "fatigue":
                return super.getStatus().getFatigue();
            case "happiness":
                return super.getStatus().getHappiness();
            case "clean":
                return super.getStatus().getClean();
            default:
                return null;
        }
    }

    @Override
    public void setNormalView() {
        setView(RenderType.HTML, GifArt.normal());
        setView(RenderType.JSON, AsciiArt.normal());
        setView(RenderType.CONSOLE, AsciiArt.normal());
    }

    @Override
    public void setView(RenderType renderType, String content) {
        switch (renderType) {
            case CONSOLE:
                super.getViews().setViewConsole(content);
                break;
            case JSON:
                super.getViews().setViewJSON(content);
                break;
            case HTML:
                super.getViews().setViewHTML(content);
                break;
            default: //nada¿?;
        }
    }


    @Override
    public void doFeed() {
        final Integer healthForEating = 10;
        final Integer coinsForEating = 2;
        final Integer fatigueForEating = 8;
        final Integer cleanForEating = 14;
        final Integer happinessForEating = 14;

        setView(RenderType.HTML, GifArt.feed());
        setView(RenderType.JSON, AsciiArt.feed());
        setView(RenderType.CONSOLE, AsciiArt.feed());
//        el pokemon cada vez que coma aumentará la vida 10p, si a la hora de comer la vida sobrepasa 145 vomitará (porque está lleno)
//        y se le restará 25 de vida.
        if ((getStatus().getHealth() + healthForEating) > 145) {
            doBarf();
        } else {
            setView(RenderType.HTML, GifArt.feed());
//        +10 de vida
            super.getStatus().setHealth(getCurrentOption("health") + healthForEating);
            super.getStatus().setCoins(getCurrentOption("coins") + coinsForEating);
            super.getStatus().setFatigue(getCurrentOption("fatigue") + fatigueForEating);
            super.getStatus().setClean(getCurrentOption("clean") - cleanForEating);
            super.getStatus().setHappiness(getCurrentOption("happiness") + happinessForEating);

        }
        DelayUtil.delay(3000);
        setNormalView();

    }

    @Override
    public void doCleanIt() {
        setView(RenderType.HTML, GifArt.cleanIt());
        setView(RenderType.JSON, AsciiArt.cleanIt());
        setView(RenderType.CONSOLE, AsciiArt.cleanIt());

        super.doCleanIt();

        DelayUtil.delay(3000);
        setNormalView();
    }

    @Override
    public void doPlay() {
        setView(RenderType.HTML, GifArt.play());
        setView(RenderType.JSON, AsciiArt.play());
        setView(RenderType.CONSOLE, AsciiArt.play());
        super.doPlay();

        DelayUtil.delay(3000);
        setNormalView();

    }

    @Override
    public void doSleep() {
        final Integer healthForSleep = 2;
        final Integer fatigueForSleep = 8;
        final Integer happinessForSleep = 10;

        setView(RenderType.HTML, GifArt.sleep());
        setView(RenderType.JSON, AsciiArt.sleep());
        setView(RenderType.CONSOLE, AsciiArt.sleep());


        super.getStatus().setHealth(getCurrentOption("health") + healthForSleep);
        if ((getCurrentOption("fatigue") - fatigueForSleep) <= 0) {
            super.getStatus().setFatigue(0);
        } else {
            super.getStatus().setFatigue(getCurrentOption("fatigue") - fatigueForSleep);
        }
        super.getStatus().setHappiness(getCurrentOption("happiness") - happinessForSleep);

    }

    @Override
    public void doReset() {
        setNormalView();
        super.doReset();
    }

    @Override
    public void doBarf() {

        final Integer healthForBarf = 25;
        final Integer fatigueForBarf = 18;
        final Integer cleanForBarf = 32;
        final Integer happinessForBarf = 26;

        setView(RenderType.HTML, GifArt.barf());
        setView(RenderType.JSON, AsciiArt.barf());
        setView(RenderType.CONSOLE, AsciiArt.barf());

        if ((getCurrentOption("fatigue") - healthForBarf) <= 0) {
            super.getStatus().setFatigue(0);
        } else {
            super.getStatus().setHealth(getCurrentOption("health") - healthForBarf);
        }
        super.getStatus().setHealth(getCurrentOption("health") - healthForBarf);
        super.getStatus().setClean(getCurrentOption("clean") - cleanForBarf);
        super.getStatus().setHappiness(getCurrentOption("happiness") - happinessForBarf);


        DelayUtil.delay(3000);
        setNormalView();
    }

    @Override
    public void doDie() {
        setView(RenderType.HTML, GifArt.die());
        setView(RenderType.JSON, AsciiArt.die());
        setView(RenderType.CONSOLE, AsciiArt.die());
        super.doDie();

        setNormalView();
    }


}
