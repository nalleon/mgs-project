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
    String name;
    Director director;
    Set<MGSCharacter> gameCharacters;

    /**
     * Default constructor of the class
     */
    public Game() {
    }

    /**
     * Constructor of the class
     * @param name of the Game
     */

    public Game(String name) {
        this.name = name;
    }

    /**
     * Full constructor of the class
     * @param name of the Game
     * @param director of the Game
     * @param gameCharacters of the Game
     */

    public Game(String name, Director director, Set<MGSCharacter> gameCharacters) {
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
        Game game = (Game) object;
        return Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", director=" + director +
                ", gameCharacters=" + gameCharacters +
                '}';
    }
}
