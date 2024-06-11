package es.ies.puerto.mgs.project.dto;

import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

public class MGSCharacterDTOTest extends TestUtilities {
    public static final int ARTIST_ID = 1;
    public static final String FULL_NAME = "artistFullName";
    public static final HashSet<MGSCharacterDTO> CHARACTERS_DESIGNED = new HashSet<>(List.of(new MGSCharacterDTO(1)));
    public static final int CHARACTER_ID = 1;
    public static final String CODENAME = "codenameTest";
    public static final int AGE = 50;
    public static final boolean STATUS = true;
    public static final String CHARACTER_NAME = "nameTest";
    ArtistDTO artist;
    MGSCharacterDTO mgsCharacter;

    @BeforeEach
    public void beforeEach(){
        mgsCharacter = new MGSCharacterDTO();
        mgsCharacter.setId(CHARACTER_ID);
        mgsCharacter.setName(CHARACTER_NAME);
        mgsCharacter.setCodename(CODENAME);
        mgsCharacter.setStatus(STATUS);
        mgsCharacter.setAge(AGE);

        artist = new ArtistDTO();
        artist.setArtistId(ARTIST_ID);
        artist.setFullName(FULL_NAME);
        //artist.setCharactersDesigned(CHARACTERS_DESIGNED);

        mgsCharacter.setArtist(artist);
    }

    @Test
    public void getSetTest(){
        Assertions.assertEquals(CHARACTER_ID, mgsCharacter.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(CHARACTER_NAME, mgsCharacter.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(CODENAME, mgsCharacter.getCodename(), MESSAGE_ERROR);
        Assertions.assertEquals(AGE, mgsCharacter.getAge(), MESSAGE_ERROR);
        Assertions.assertEquals(STATUS, mgsCharacter.isStatus(), MESSAGE_ERROR);
        Assertions.assertEquals(artist, mgsCharacter.getArtist(), MESSAGE_ERROR);
    }

    @Test
    public void toStringTest(){
        Assertions.assertTrue(mgsCharacter.toString().contains(String.valueOf(CHARACTER_ID)), MESSAGE_ERROR);
        Assertions.assertTrue(mgsCharacter.toString().contains(CHARACTER_NAME), MESSAGE_ERROR);
        Assertions.assertTrue(mgsCharacter.toString().contains(CODENAME), MESSAGE_ERROR);
        Assertions.assertTrue(mgsCharacter.toString().contains(String.valueOf(AGE)), MESSAGE_ERROR);
        Assertions.assertTrue(mgsCharacter.toString().contains(String.valueOf(STATUS)), MESSAGE_ERROR);
        Assertions.assertTrue(mgsCharacter.toString().contains(artist.toString()), MESSAGE_ERROR);
    }

    @Test
    public void equalsTest(){
        MGSCharacterDTO equals = new MGSCharacterDTO(CHARACTER_ID);
        MGSCharacterDTO notEquals = new MGSCharacterDTO(2, CHARACTER_NAME, CODENAME, AGE, STATUS, artist);
        String str = "str";
        MGSCharacterDTO nullObject = null;

        Assertions.assertTrue(mgsCharacter.equals(equals), MESSAGE_ERROR);
        Assertions.assertTrue(mgsCharacter.equals(mgsCharacter), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacter.hashCode(), equals.hashCode(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacter, equals, MESSAGE_ERROR);
        Assertions.assertFalse(mgsCharacter.equals(nullObject), MESSAGE_ERROR);
        Assertions.assertFalse(mgsCharacter.equals(notEquals), MESSAGE_ERROR);
        Assertions.assertFalse(mgsCharacter.equals(str), MESSAGE_ERROR);
    }
}
