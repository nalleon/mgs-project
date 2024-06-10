package es.ies.puerto.mgs.project.model.entities;

import java.util.Objects;
import java.util.Set;

/**
 * @author nalleon
 */
public class Game {
    /**
     * Properties
     */
    int id;
    String name;
    Set<MGSCharacter> gameCharacters;

    /**
     * Default constructor of the class
     */
    public Game() {
    }

    /**
     * Constructor of the class
     * @param id of the Game
     */

    public Game(int id) {
        this.id = id;
    }

    /**
     * Full constructor of the class
     * @param id of the Game
     * @param name of the Game
     * @param director of the Game
     * @param gameCharacters of the Game
     */
    public Game(int id, String name, Director director, Set<MGSCharacter> gameCharacters) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.gameCharacters = gameCharacters;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director=" + director +
                ", gameCharacters=" + gameCharacters +
                '}';
    }
}
