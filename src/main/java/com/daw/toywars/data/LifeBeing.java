package com.daw.toywars.data;

import java.util.List;

public abstract class LifeBeing implements LivingBeingActions, IRender {
    @Override
    public void doFeed(Action action) {

    }

    @Override
    public void doCleanIt(Action action) {

    }

    @Override
    public void doWalk(Action action) {

    }

    @Override
    public void doPlay(Action action) {

    }

    @Override
    public void doSleep(Action action) {

    }

    @Override
    public void doDie(Action action) {

    }

    @Override
    public List<Action> getCurrentActions(Action action) {
        return null;
    }
}
