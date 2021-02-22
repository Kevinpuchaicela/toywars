package com.daw.toywars.data;

public class Status {
    private Integer health;
    private Integer coins;
    private Integer fatigue;
    private Integer happiness;
    private Integer clean;

    public Status() {
        this.health = 100;
        this.coins = 0;
        this.fatigue = 0;
        this.happiness = 40;
        this.clean = 100;
    }

    public Status(Integer health, Integer coins, Integer fatigue, Integer happiness, Integer clean) {
        this.health = health;
        this.coins = coins;
        this.fatigue = fatigue;
        this.happiness = happiness;
        this.clean = clean;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getFatigue() {
        return fatigue;
    }

    public void setFatigue(Integer fatigue) {
        this.fatigue = fatigue;
    }

    public Integer getHappiness() {
        return happiness;
    }

    public void setHappiness(Integer happiness) {
        this.happiness = happiness;
    }

    public Integer getClean() {
        return clean;
    }

    public void setClean(Integer clean) {
        this.clean = clean;
    }
}
