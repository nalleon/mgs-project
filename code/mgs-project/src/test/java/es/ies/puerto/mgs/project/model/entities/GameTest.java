package es.ies.puerto.mgs.project.model.entities;

import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

public class GameTest extends TestUtilities {

    Game game;
    Director director;
    public static final int DIRECTOR_ID = 1;
    public static final String FULL_NAME = "artistFullName";
    public static final HashSet<Game> GAMES_DIRECTED = new HashSet<>(List.of(new Game(1)));
    public static final int GAME_ID = 1;
    public static final String NAME = "artistFullName";
    public static final HashSet<MGSCharacter> GAME_CHARACTERS = new HashSet<>(List.of(new MGSCharacter(1)));

    @BeforeEach
    public void beforeEach(){
        game = new Game();
        game.setId(GAME_ID);
        game.setName(NAME);
        director = new Director();
        director.setDirectorId(DIRECTOR_ID);
        director.setFullName(FULL_NAME);
        director.setGamesDirected(GAMES_DIRECTED);
        game.setDirector(director);
        game.setGameCharacters(GAME_CHARACTERS);

    }

    @Test
    public void getSetTest(){
        Assertions.assertEquals(GAME_ID, game.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(NAME, game.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(director, game.getDirector(), MESSAGE_ERROR);
        Assertions.assertEquals(GAME_CHARACTERS, game.getGameCharacters(), MESSAGE_ERROR);
    }

    @Test
    public void toStringTest(){
        Assertions.assertTrue(game.toString().contains(String.valueOf(GAME_ID)), MESSAGE_ERROR);
        Assertions.assertTrue(game.toString().contains(NAME), MESSAGE_ERROR);
        Assertions.assertTrue(game.toString().contains(director.toString()), MESSAGE_ERROR);
        Assertions.assertTrue(game.toString().contains(GAME_CHARACTERS.toString()), MESSAGE_ERROR);
    }

    @Test
    public void equalsTest(){
        Game equals = new Game(GAME_ID);
        Game notEquals = new Game(2, NAME, GAME_CHARACTERS, director);
        String str = "str";
        Game nullObject = null;

        Assertions.assertTrue(game.equals(equals), MESSAGE_ERROR);
        Assertions.assertEquals(game.hashCode(), equals.hashCode(), MESSAGE_ERROR);
        Assertions.assertEquals(game, equals, MESSAGE_ERROR);
        Assertions.assertFalse(game.equals(nullObject), MESSAGE_ERROR);
        Assertions.assertFalse(game.equals(notEquals), MESSAGE_ERROR);
        Assertions.assertFalse(game.equals(str), MESSAGE_ERROR);
    }
}
