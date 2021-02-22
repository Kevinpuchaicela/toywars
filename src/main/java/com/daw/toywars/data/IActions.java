package com.daw.toywars.data;

import java.util.List;

public interface IActions {
    public void doFeed();

    public void doCleanIt();

    public void doPlay();

    public void doDie();

    public void doSleep();

    public void doReset();

    public void doBarf();

    public List<Action> getCurrentActions(Action action);
}
