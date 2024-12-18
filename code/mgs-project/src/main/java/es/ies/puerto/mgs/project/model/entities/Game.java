package es.ies.puerto.mgs.project.model.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;


import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author nalleon
 */

@Entity
@Table(name = "games")
public class Game implements Serializable {
    /**
     * Properties
     */
    @Id
    int id;
    String name;

    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "games_mgscharacters",
            joinColumns = { @JoinColumn(name = "game_id") },
            inverseJoinColumns = { @JoinColumn(name = "mgsCharacter_id")})
    Set<MGSCharacter> gameCharacters;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    Director director;

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
     * @param gameCharacters of the Game
     */
    public Game(int id, String name, Set<MGSCharacter> gameCharacters) {
        this.id = id;
        this.name = name;
        this.gameCharacters = gameCharacters;
        //this.director = director;
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
                ", gameCharacters=" + gameCharacters +
                '}';
    }
}
