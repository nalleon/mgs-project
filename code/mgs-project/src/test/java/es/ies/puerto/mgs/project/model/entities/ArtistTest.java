package es.ies.puerto.mgs.project.model.entities;

import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashSet;
import java.util.List;

public class ArtistTest extends TestUtilities {

    public static final int ARTIST_ID = 1;
    public static final String FULL_NAME = "artistFullName";
    public static final HashSet<MGSCharacter> CHARACTERS_DESIGNED = new HashSet<>(List.of(new MGSCharacter(1)));
    Artist artist;

    @BeforeEach
    public void beforeEach(){
        artist = new Artist();
        artist.setArtistId(ARTIST_ID);
        artist.setFullName(FULL_NAME);
        artist.setCharactersDesigned(CHARACTERS_DESIGNED);
    }

   @Test
    public void getSetTest(){
        Assertions.assertEquals(ARTIST_ID, artist.getArtistId(), MESSAGE_ERROR);
        Assertions.assertEquals(FULL_NAME, artist.getFullName(), MESSAGE_ERROR);
        Assertions.assertEquals(CHARACTERS_DESIGNED, artist.getCharactersDesigned(), MESSAGE_ERROR);
    }

    @Test
    public void toStringTest(){
        Assertions.assertTrue(artist.toString().contains(String.valueOf(ARTIST_ID)), MESSAGE_ERROR);
        Assertions.assertTrue(artist.toString().contains(FULL_NAME), MESSAGE_ERROR);
        Assertions.assertTrue(artist.toString().contains(CHARACTERS_DESIGNED.toString()), MESSAGE_ERROR);
    }

    @Test
    public void equalsTest(){
        Artist equals = new Artist(ARTIST_ID);
        Artist notEquals = new Artist(2, FULL_NAME, CHARACTERS_DESIGNED);
        String str = "str";
        Artist nullObject = null;

        Assertions.assertTrue(artist.equals(equals), MESSAGE_ERROR);
        Assertions.assertTrue(artist.equals(artist), MESSAGE_ERROR);
        Assertions.assertEquals(artist.hashCode(), equals.hashCode(), MESSAGE_ERROR);
        Assertions.assertEquals(artist, equals, MESSAGE_ERROR);
        Assertions.assertFalse(artist.equals(nullObject), MESSAGE_ERROR);
        Assertions.assertFalse(artist.equals(notEquals), MESSAGE_ERROR);
        Assertions.assertFalse(artist.equals(str), MESSAGE_ERROR);
    }
}
