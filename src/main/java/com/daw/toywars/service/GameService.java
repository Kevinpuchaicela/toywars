package com.daw.toywars.service;

import com.daw.toywars.data.*;
import com.daw.toywars.data.puppets.pokemons.Pokemon;
import com.daw.toywars.data.puppets.pokemons.PokemonType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    public static List<UserAction> userActions = new ArrayList<>();
    public int maxPoints = 100;
    public LifeBeing currentLifeBeing;
    /* agregado por kevin*/


    public void doAction(Action action) {
        switch (action) {
            case FEED:
                currentLifeBeing.doFeed();
                break;
            case CLEANIT:
                currentLifeBeing.doCleanIt();
                break;
            case WALK:
                currentLifeBeing.doWalk();
                break;
            case PLAY:
                currentLifeBeing.doPlay();
                break;
            case DIE:
                currentLifeBeing.doDie();
                break;
            case SLEEP:
                currentLifeBeing.doSleep();
                break;
            case FIGHT:
                currentLifeBeing.doFight();
                break;
            case RESET:
                currentLifeBeing.doReset();
            default:
        }

        Status status = new Status(currentLifeBeing.getStatus().getHealthPoints(), currentLifeBeing.getStatus().getExperiencePoints(), action);
        currentLifeBeing.setStatus(status);
        UserAction userAction = new UserAction(currentLifeBeing);
        userActions.add(userAction);
    }

    public void resetLifeBeing() {
        currentLifeBeing.doReset();
        Status status = new Status(maxPoints, 0, Action.RESET);
        currentLifeBeing.setStatus(status);
        UserAction userAction = new UserAction(currentLifeBeing);
        userActions.add(userAction);
    }

    public String render(RenderType renderType) {
        return currentLifeBeing.doRender(renderType);
    }

    public List<UserAction> getUserActions() {
        return userActions;
    }

    public LifeBeing getCurrentLifeBeing() {
        return currentLifeBeing;
    }

    public void setCurrentLifeBeing(LifeBeing currentLifeBeing) {
        this.currentLifeBeing = currentLifeBeing;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
}
