package com.daw.toywars;

import com.daw.toywars.data.Action;
import com.daw.toywars.data.LifeBeing;
import com.daw.toywars.data.Status;
import com.daw.toywars.data.puppets.pokemons.Pokemon;
import com.daw.toywars.data.puppets.pokemons.PokemonType;
import com.daw.toywars.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToywarsApplicationTests {
    GameService gameService =  new GameService();
    @Test
    void contextLoads(  ) {
        LifeBeing pikachu = new Pokemon("Kevin", "red", new Status(), PokemonType.FIRE);
        gameService.setCurrentLifeBeing(pikachu);
        gameService.resetLifeBeing();

        //acción
        gameService.doAction(Action.FIGHT);
    }

}
