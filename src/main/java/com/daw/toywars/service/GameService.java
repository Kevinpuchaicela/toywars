package com.daw.toywars.service;

import com.daw.toywars.data.*;
import com.daw.toywars.data.Action;
import com.daw.toywars.data.puppets.Puppet;
import com.daw.toywars.data.puppets.pokemons.Pokemon;
import com.daw.toywars.data.puppets.tamagochi.Tamagochi;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    public final List<UserAction> userActions = new ArrayList<>();
    public int maxPoints;
    public Puppet currentPuppet;


    public void doAction(Action action) {
        switch (action) {
            case FEED:
                currentPuppet.doFeed();
                break;
            case CLEANIT:
                currentPuppet.doCleanIt();
                break;
            case PLAY:
                currentPuppet.doPlay();
                break;
            case SLEEP:
                currentPuppet.doSleep();
                break;
            case RESET:
                currentPuppet.doReset();
            default:
        }

        UserAction userAction = new UserAction(currentPuppet.getName(), currentPuppet.getStatus(), action);
        userActions.add(userAction);
    }

    public String render(RenderType renderType) {
        return currentPuppet.doRender(renderType);
    }

    public List<UserAction> getUserActions() {
        return userActions;
    }

    public Puppet getCurrentPuppet() {
        return currentPuppet;
    }

    public void setCurrentPuppet(Puppet currentPuppet) {
        this.currentPuppet = currentPuppet;
    }

    public void createNewPokemon(Pokemon pokemon) {
        Puppet poke = new Pokemon(pokemon.getName(), pokemon.getColorType(), pokemon.getPokemonType());
        setCurrentPuppet(poke);
        doAction(Action.RESET); //Se puede omitir este paso pero no apareceria en el historico de acciones.
    }

    public void createNewTamagochi(Tamagochi tamagochi) {
        Puppet tama = new Tamagochi(tamagochi.getName(), tamagochi.getColorType(), tamagochi.getTamaType());
        setCurrentPuppet(tama);
        doAction(Action.RESET);
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
}
