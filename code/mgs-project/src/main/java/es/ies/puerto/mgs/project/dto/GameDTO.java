package es.ies.puerto.mgs.project.dto;

import es.ies.puerto.mgs.project.model.entities.Director;
import es.ies.puerto.mgs.project.model.entities.Game;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;

import java.util.Objects;
import java.util.Set;

/**
 * @author nalleon
 */
public class GameDTO {
    /**
     * Properties
     */
    String name;
    Director director;
    Set<MGSCharacter> gameCharacters;

    /**
     * Default constructor of the class
     */
    public GameDTO() {
    }

    /**
     * Constructor of the class
     * @param name of the Game
     */

    public GameDTO(String name) {
        this.name = name;
    }

    /**
     * Full constructor of the class
     * @param name of the Game
     * @param director of the Game
     * @param gameCharacters of the Game
     */

    public GameDTO(String name, Director director, Set<MGSCharacter> gameCharacters) {
        this.name = name;
        this.director = director;
        this.gameCharacters = gameCharacters;
    }

    /**
     * Getters and setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Set<MGSCharacter> getGameCharacters() {
        return gameCharacters;
    }

    public void setGameCharacters(Set<MGSCharacter> gameCharacters) {
        this.gameCharacters = gameCharacters;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        GameDTO game = (GameDTO) object;
        return Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "GameDTO{" +
                "name='" + name + '\'' +
                ", director=" + director +
                ", gameCharacters=" + gameCharacters +
                '}';
    }
}
