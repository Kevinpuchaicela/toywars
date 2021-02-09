package com.daw.toywars.data;

import java.util.List;

public interface LivingBeingActions{
    public void doFeed(Action action);

    public void doCleanIt(Action action);

    public void doWalk(Action action);

    public void doPlay(Action action);

    public void doSleep(Action action);

    public void doDie(Action action);

    public List<Action> getCurrentActions(Action action);
}
