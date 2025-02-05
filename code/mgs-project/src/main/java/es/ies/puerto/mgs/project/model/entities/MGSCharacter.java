package es.ies.puerto.mgs.project.model.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;


import jakarta.persistence.*;


/**
 * @author nalleon
 */

@Entity
@Table(name = "mgscharacters")
public class MGSCharacter implements Serializable {
    /**
     * Properties
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String codename;
    int age;
    boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_artist_id")
    Artist artist;
    @ManyToMany(mappedBy = "gameCharacters", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    Set<Game> games;

    /**
     * Default constructor of the class
     */
    public MGSCharacter() {
    }

    /**
     * Constructor of the class
     * @param id of the MGSCharacter
     */
    public MGSCharacter(int id) {
        this.id = id;
    }

    /**
     * Full constructor of the class
     * @param id of the MGSCharacter
     * @param codename of the MGSCharacter
     * @param age of the MGSCharacter
     * @param status of the MGSCharacter
     * @param name of the MGSCharacter
     * @param artist of the MGSCharacter
     */

    public MGSCharacter(int id, String name, String codename, int age, boolean status, Artist artist) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.codename = codename;
        this.status = status;
        this.artist = artist;
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

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MGSCharacter that = (MGSCharacter) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "MGSCharacter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", codename='" + codename + '\'' +
                ", age=" + age +
                ", status=" + status +
                ", artist=" + artist +
                '}';
    }
}
