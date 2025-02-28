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
@Table(name = "directors")
public class Director implements Serializable {
    /**
     * Properties
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int directorId;
    String fullName;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<Game> gamesDirected;

    /**
     * Default constructor of the class
     */
    public Director() {
    }

    /**
     * Constructor of the class
     * @param directorId of the Director
     */

    public Director(int directorId) {
        this.directorId = directorId;
    }

    /**
     * Constructor of the class
     * @param directorId of the Director
     * @param fullName of the Director
     */
    public Director(int directorId, String fullName) {
        this.directorId = directorId;
        this.fullName = fullName;
    }

    /**
     * Full constructor of the class
     * @param directorId of the Director
     * @param fullName of the Director
     * @param gamesDirected of the Director
     */

    public Director(int directorId, String fullName, Set<Game> gamesDirected) {
        this.directorId = directorId;
        this.fullName = fullName;
        this.gamesDirected = gamesDirected;
    }

    /**
     * Getters and setters
     */
    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Game> getGamesDirected() {
        return gamesDirected;
    }

    public void setGamesDirected(Set<Game> gamesDirected) {
        this.gamesDirected = gamesDirected;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Director director = (Director) object;
        return directorId == director.directorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(directorId);
    }

    @Override
    public String toString() {
        return "Director{" +
                "directorId=" + directorId +
                ", fullName='" + fullName + '\'' +
                ", gamesDirected=" + gamesDirected +
                '}';
    }
}
