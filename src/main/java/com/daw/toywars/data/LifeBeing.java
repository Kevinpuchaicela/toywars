package com.daw.toywars.data;

import java.util.List;

public abstract class LifeBeing implements IActions, IRender {
    public Status status;

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
