package es.ies.puerto.mgs.project.dto;

import es.ies.puerto.mgs.project.model.entities.Director;
import es.ies.puerto.mgs.project.model.entities.Game;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

public class DirectorDTOTest extends TestUtilities {
    DirectorDTO director;
    public static final int DIRECTOR_ID = 1;
    public static final String FULL_NAME = "artistFullName";
    public static final HashSet<GameDTO> GAMES_DIRECTED = new HashSet<>(List.of(new GameDTO(1)));

    @BeforeEach
    public void beforeEach(){
        director = new DirectorDTO();
        director.setDirectorId(DIRECTOR_ID);
        director.setFullName(FULL_NAME);
        director.setGamesDirected(GAMES_DIRECTED);
    }

    @Test
    public void getSetTest(){
        Assertions.assertEquals(DIRECTOR_ID, director.getDirectorId(), MESSAGE_ERROR);
        Assertions.assertEquals(FULL_NAME, director.getFullName(), MESSAGE_ERROR);
        Assertions.assertEquals(GAMES_DIRECTED, director.getGamesDirected(), MESSAGE_ERROR);
    }

    @Test
    public void toStringTest(){
        Assertions.assertTrue(director.toString().contains(String.valueOf(DIRECTOR_ID)), MESSAGE_ERROR);
        Assertions.assertTrue(director.toString().contains(FULL_NAME), MESSAGE_ERROR);
        Assertions.assertTrue(director.toString().contains(GAMES_DIRECTED.toString()), MESSAGE_ERROR);
    }

    @Test
    public void equalsTest(){
        DirectorDTO equals = new DirectorDTO(DIRECTOR_ID);
        DirectorDTO notEquals = new DirectorDTO(2, FULL_NAME, GAMES_DIRECTED);
        String str = "str";
        DirectorDTO nullObject = null;

        Assertions.assertTrue(director.equals(equals), MESSAGE_ERROR);
        Assertions.assertEquals(director.hashCode(), equals.hashCode(), MESSAGE_ERROR);
        Assertions.assertEquals(director, equals, MESSAGE_ERROR);
        Assertions.assertFalse(director.equals(nullObject), MESSAGE_ERROR);
        Assertions.assertFalse(director.equals(notEquals), MESSAGE_ERROR);
        Assertions.assertFalse(director.equals(str), MESSAGE_ERROR);
    }
}
