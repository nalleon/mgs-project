package es.ies.puerto.mgs.project.dto;

import es.ies.puerto.mgs.project.model.entities.Director;
import es.ies.puerto.mgs.project.model.entities.Game;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

public class GameDTOTest extends TestUtilities {
    public static final DirectorDTO DIRECTOR = new DirectorDTO(1);
    GameDTO game;
    public static final int GAME_ID = 1;
    public static final String NAME = "nameTest";
    public static final HashSet<MGSCharacterDTO> GAME_CHARACTERS = new HashSet<>(List.of(new MGSCharacterDTO(1)));

    @BeforeEach
    public void beforeEach(){
        game = new GameDTO();
        game.setId(GAME_ID);
        game.setName(NAME);
        game.setGameCharacters(GAME_CHARACTERS);
        game.setDirector(DIRECTOR);
    }

    @Test
    public void getSetTest(){
        Assertions.assertEquals(GAME_ID, game.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(NAME, game.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(GAME_CHARACTERS, game.getGameCharacters(), MESSAGE_ERROR);
        Assertions.assertEquals(DIRECTOR, game.getDirector(), MESSAGE_ERROR);
    }

    @Test
    public void toStringTest(){
        Assertions.assertTrue(game.toString().contains(String.valueOf(GAME_ID)), MESSAGE_ERROR);
        Assertions.assertTrue(game.toString().contains(NAME), MESSAGE_ERROR);
        Assertions.assertTrue(game.toString().contains(GAME_CHARACTERS.toString()), MESSAGE_ERROR);
        Assertions.assertTrue(game.toString().contains(DIRECTOR.toString()), MESSAGE_ERROR);

    }

    @Test
    public void equalsTest(){
        GameDTO equals = new GameDTO(GAME_ID);
        GameDTO notEquals = new GameDTO(2, NAME, GAME_CHARACTERS);
        String str = "str";
        GameDTO nullObject = null;

        Assertions.assertTrue(game.equals(equals), MESSAGE_ERROR);
        Assertions.assertTrue(game.equals(game), MESSAGE_ERROR);
        Assertions.assertEquals(game.hashCode(), equals.hashCode(), MESSAGE_ERROR);
        Assertions.assertEquals(game, equals, MESSAGE_ERROR);
        Assertions.assertFalse(game.equals(nullObject), MESSAGE_ERROR);
        Assertions.assertFalse(game.equals(notEquals), MESSAGE_ERROR);
        Assertions.assertFalse(game.equals(str), MESSAGE_ERROR);
    }

}
