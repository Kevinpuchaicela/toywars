package com.daw.toywars.data.puppets;

import com.daw.toywars.data.*;

import java.util.List;
import java.util.UUID;

public class Puppet extends LifeBeing implements IActions, IRender {
    private String id;
    private View views;
    private String colorType;
    private Status status;

    public Puppet(String name, String colorType) {
        super(name);
        this.id = "puppet" + UUID.randomUUID().toString();
        this.views = new View();
        this.colorType = colorType;
        this.status = new Status();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public View getViews() {
        return views;
    }

    public void setViews(View views) {
        this.views = views;
    }

    public Integer getCurrentOption(String option) {
        switch (option) {
            case "health":
                return getStatus().getHealth();
            case "coins":
                return getStatus().getCoins();
            case "fatigue":
                return getStatus().getFatigue();
            case "happiness":
                return getStatus().getHappiness();
            case "clean":
                return getStatus().getClean();
            default:
                return null;
        }
    }
    @Override
    public void setNormalView() {
        setView(RenderType.HTML, AsciiArt.normal());
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

    @Override
    public void doFeed() {

    }

    @Override
    public void doCleanIt() {
        final Integer coinsForClean = 2;
        final Integer cleanForClean = 14;
        final Integer happinessForClean = 14;

        getStatus().setCoins(getCurrentOption("coins") + coinsForClean);
        if ((getCurrentOption("health") + cleanForClean) >= 100){
            getStatus().setClean(100);
        }else{
            getStatus().setClean(getCurrentOption("clean") + cleanForClean);
        }

        getStatus().setHappiness(getCurrentOption("happiness") + happinessForClean);
    }

    @Override
    public void doPlay() {
        final Integer coinsForPlay = 7;
        final Integer fatigueForPlay = 12;
        final Integer cleanForPlay = 13;
        final Integer happinessForPlay = 14;

        getStatus().setCoins(getCurrentOption("coins") + coinsForPlay);
        getStatus().setFatigue(getCurrentOption("fatigue") + fatigueForPlay);
        getStatus().setClean(getCurrentOption("clean") - cleanForPlay);
        getStatus().setHappiness(getCurrentOption("happiness") + happinessForPlay);


    }

    @Override
    public void doDie() {
        Status statusDie = new Status(0, 0, 0, 0, 0);
        setStatus(statusDie);
    }

    @Override
    public void doSleep() {

    }

    @Override
    public void doReset() {
        setStatus(new Status());
    }

    @Override
    public void doBarf() {

    }

    @Override
    public List<Action> getCurrentActions(Action action) {
        return null;
    }

    @Override
    public String doRender(RenderType renderType) {
        switch (renderType) {
            case CONSOLE:
                return getViews().getViewConsole();
            case HTML:
                return getViews().getViewHTML();
            default:
                return getViews().getViewJSON();

        }
    }
}
