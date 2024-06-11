package es.ies.puerto.mgs.project.utilities;

import es.ies.puerto.mgs.project.dto.*;
import es.ies.puerto.mgs.project.model.entities.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.List;

public class MapperHelper extends TestUtilities {

    public static final int ARTIST_ID = 1;
    public static final String FULL_NAME = "artistFullName";
    public static final HashSet<MGSCharacter> CHARACTERS_DESIGNED = new HashSet<>(List.of(new MGSCharacter(1)));
    public static final HashSet<MGSCharacterDTO> CHARACTERS_DESIGNED_DTO = new HashSet<>(List.of(new MGSCharacterDTO(1)));

    public static final int DIRECTOR_ID = 1;
    public static final HashSet<Game> GAMES_DIRECTED = new HashSet<>(List.of(new Game(1)));
    public static final HashSet<GameDTO> GAMES_DIRECTED_DTO = new HashSet<>(List.of(new GameDTO(1)));

    public static final int GAME_ID = 1;
    public static final HashSet<MGSCharacter> GAME_CHARACTERS = new HashSet<>(List.of(new MGSCharacter(1)));
    public static final HashSet<MGSCharacterDTO> GAME_CHARACTERS_DTO = new HashSet<>(List.of(new MGSCharacterDTO(1)));

    public static final int WEAPON_ID = 1;
    public static final String NAME = "nameTest";
    public static final String TYPE = "typeTest";
    public static final int CHARACTER_ID = 1;
    public static final String CODENAME = "codenameTest";
    public static final int AGE = 50;
    public static final boolean STATUS = true;
    public static final String CHARACTER_NAME = "nameTest";

    public Artist artist;
    public  ArtistDTO artistDTO;

    public Director director;
    public DirectorDTO directorDTO;

    public Game game;
    public GameDTO gameDTO;

    public MGSCharacter mgsCharacter;
    public MGSCharacterDTO mgsCharacterDTO;

    public Weapon weapon;
    public WeaponDTO weaponDTO;

    @BeforeEach
    public void beforeEach(){
        weapon = new Weapon();
        weapon.setId(WEAPON_ID);
        weapon.setName(NAME);
        weapon.setType(TYPE);

        weaponDTO = new WeaponDTO();
        weaponDTO.setId(WEAPON_ID);
        weaponDTO.setName(NAME);
        weaponDTO.setType(TYPE);

        game = new Game();
        game.setId(GAME_ID);
        game.setName(NAME);
        game.setGameCharacters(GAME_CHARACTERS);
        //game.setDirector(director);

        gameDTO = new GameDTO();
        gameDTO.setId(GAME_ID);
        gameDTO.setName(NAME);
        gameDTO.setGameCharacters(CHARACTERS_DESIGNED_DTO);
       // gameDTO.setDirector(directorDTO);

        director = new Director();
        director.setDirectorId(DIRECTOR_ID);
        director.setFullName(FULL_NAME);
        director.setGamesDirected(new HashSet<>(List.of(game)));


        directorDTO = new DirectorDTO();
        directorDTO.setDirectorId(DIRECTOR_ID);
        directorDTO.setFullName(FULL_NAME);
        //directorDTO.setGamesDirected(new HashSet<>(List.of(gameDTO)));

        artist = new Artist();
        artist.setArtistId(ARTIST_ID);
        artist.setFullName(FULL_NAME);
        artist.setCharactersDesigned(CHARACTERS_DESIGNED);

        artistDTO = new ArtistDTO();
        artistDTO.setArtistId(ARTIST_ID);
        artistDTO.setFullName(FULL_NAME);
        //artistDTO.setCharactersDesigned(CHARACTERS_DESIGNED_DTO);


        mgsCharacter = new MGSCharacter();
        mgsCharacter.setId(CHARACTER_ID);
        mgsCharacter.setName(CHARACTER_NAME);
        mgsCharacter.setCodename(CODENAME);
        mgsCharacter.setStatus(STATUS);
        mgsCharacter.setAge(AGE);
        mgsCharacter.setArtist(artist);

        mgsCharacterDTO = new MGSCharacterDTO();
        mgsCharacterDTO.setId(CHARACTER_ID);
        mgsCharacterDTO.setName(CHARACTER_NAME);
        mgsCharacterDTO.setCodename(CODENAME);
        mgsCharacterDTO.setStatus(STATUS);
        mgsCharacterDTO.setAge(AGE);
        mgsCharacterDTO.setArtist(artistDTO);

    }
}
