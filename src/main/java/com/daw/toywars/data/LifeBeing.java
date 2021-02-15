package com.daw.toywars.data;

import java.util.List;

public abstract class LifeBeing implements IActions, IRender {
    private String name;
    private String colorType;
    private Status status;

    public LifeBeing(String name, String colorType, Status status) {
        this.name = name;
        this.colorType = colorType;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public void doFeed() {

    }

    @Override
    public void doCleanIt() {

    }

    @Override
    public void doWalk() {

    }

    @Override
    public void doPlay() {

    }

    @Override
    public void doSleep() {

    }

    @Override
    public void doDie() {

    }

    @Override
    public List<Action> getCurrentActions(Action action) {
        return null;
    }
}
