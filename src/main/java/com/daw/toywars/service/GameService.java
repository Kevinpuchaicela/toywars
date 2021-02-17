package com.daw.toywars.service;

import com.daw.toywars.data.*;
import com.daw.toywars.data.puppets.PuppetType;
import com.daw.toywars.data.puppets.pokemons.Pokemon;
import com.daw.toywars.data.puppets.pokemons.PokemonType;
import com.daw.toywars.data.puppets.tamagochi.Tamagochi;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    public final List<UserAction> userActions = new ArrayList<>();
    public int maxPoints = 100;
    public LifeBeing currentLifeBeing;

    /*agregado por mi*/
    public String currentRender;  //TODO: hacer que el render quede guardado en memoria service

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

        UserAction userAction = new UserAction(currentLifeBeing.getName(), currentLifeBeing.getStatus(), action);
        userActions.add(userAction);
    }

    public void resetLifeBeing() {
        currentLifeBeing.doReset();
        Status status = new Status(maxPoints, 0);
        currentLifeBeing.setStatus(status);
        UserAction userAction = new UserAction(currentLifeBeing.getName(), currentLifeBeing.getStatus(), Action.RESET);
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

    public void createNewPokemon(Pokemon pokemon) {
        LifeBeing poke = new Pokemon(pokemon.getName(), pokemon.getColorType(), pokemon.getStatus(), pokemon.getPokemonType());
        setCurrentLifeBeing(poke);
        resetLifeBeing();
        //TODO: asociar el puppet al player
    }

    public void createNewTamagochi(Tamagochi tamagochi) {
        LifeBeing tama = new Tamagochi(tamagochi.getName(), tamagochi.getColorType(), tamagochi.getStatus(), tamagochi.getTamaType());
        setCurrentLifeBeing(tama);
        resetLifeBeing();
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public String getCurrentRender() {
        return currentRender;
    }

    public void setCurrentRender(String currentRender) {
        this.currentRender = currentRender;
    }
}
