package com.daw.toywars.data.puppets.tamagochi;

import com.daw.toywars.data.*;
import com.daw.toywars.data.puppets.AsciiArt;
import com.daw.toywars.data.puppets.GifArt;
import com.daw.toywars.data.puppets.Puppet;
import com.daw.toywars.data.utils.DelayUtil;

public class Tamagochi extends Puppet {
    private TamaType tamaType;

    public Tamagochi(String name, String colorType, TamaType tamaType) {
        super(name, colorType);
        this.tamaType = tamaType;
    }

    public TamaType getTamaType() {
        return tamaType;
    }

    public void setTamaType(TamaType tamaType) {
        this.tamaType = tamaType;
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
                getViews().setViewConsole(content);
                break;
            case JSON:
                getViews().setViewJSON(content);
                break;
            case HTML:
                getViews().setViewHTML(content);
                break;
            default: //nada¿?;
        }
    }

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
    public void doFeed() {
        final Integer healthForEating = 23;
        final Integer coinsForEating = 4;
        final Integer fatigueForEating = 12;
        final Integer cleanForEating = 11;
        final Integer happinessForEating = 9;

        setView(RenderType.HTML, GifArt.feed());
        setView(RenderType.JSON, AsciiArt.feed());
        setView(RenderType.CONSOLE, AsciiArt.feed());

//        el pokemon cada vez que coma aumentará la vida 10p, si a la hora de comer la vida sobrepasa 145 vomitará (porque está lleno)
//        y se le restará 25 de vida.
        if ((getCurrentOption("health") + healthForEating) > 145) {
            doBarf();
        } else {
            super.getStatus().setHealth(getCurrentOption("health") + healthForEating);
            super.getStatus().setCoins(getCurrentOption("coins") + coinsForEating);
            super.getStatus().setFatigue(getCurrentOption("fatigue") + fatigueForEating);
            super.getStatus().setClean(getCurrentOption("clean") - cleanForEating);
            super.getStatus().setHappiness(getCurrentOption("happiness") - happinessForEating);
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
        final Integer fatigueForSleep = 3;
        final Integer happinessForSleep = 17;

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
        final Integer fatigueForBarf = 24;
        final Integer cleanForBarf = 12;
        final Integer happinessForBarf = 16;

        setView(RenderType.HTML, GifArt.barf());
        setView(RenderType.JSON, AsciiArt.barf());
        setView(RenderType.CONSOLE, AsciiArt.barf());

        if ((getCurrentOption("fatigue") - healthForBarf) <= 0) {
            super.getStatus().setFatigue(0);
        } else {
            super.getStatus().setHealth(getCurrentOption("health") - healthForBarf);
        }
        super.getStatus().setFatigue(getCurrentOption("fatigue") + fatigueForBarf);
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
