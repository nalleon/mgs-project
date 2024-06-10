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
    int id;
    String name;
    Set<MGSCharacter> gameCharacters;
    Director director;

    /**
     * Default constructor of the class
     */
    public GameDTO() {
    }

    /**
     * Constructor of the class
     * @param id of the Game
     */

    public GameDTO(int id) {
        this.id = id;
    }

    /**
     * Full constructor of the class
     * @param id of the Game
     * @param name of the Game
     * @param gameCharacters of the Game
     * @param director of the Game
     */
    public GameDTO(int id, String name, Set<MGSCharacter> gameCharacters, Director director) {
        this.id = id;
        this.name = name;
        this.gameCharacters = gameCharacters;
        this.director = director;
    }

    /**
     * Getters and setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MGSCharacter> getGameCharacters() {
        return gameCharacters;
    }

    public void setGameCharacters(Set<MGSCharacter> gameCharacters) {
        this.gameCharacters = gameCharacters;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameDTO gameDTO = (GameDTO) o;
        return id == gameDTO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "GameDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gameCharacters=" + gameCharacters +
                ", director=" + director +
                '}';
    }
}
