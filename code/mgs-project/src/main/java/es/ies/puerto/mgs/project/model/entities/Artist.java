package es.ies.puerto.mgs.project.model.entities;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author nalleon
 */
@Entity
@Table(name = "artists")
public class Artist implements Serializable {
    /**
     * Properties
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    int artistId;
    String fullName;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<MGSCharacter> charactersDesigned;

    /**
     * Default constructor of the class
     */
    public Artist() {
    }

    /**
     * Constructor of the class
     * @param artistId of the Artist
     */
    public Artist(int artistId) {
        this.artistId = artistId;
    }

    /**
     * Full constructor of the class
     * @param artistId of the Artist
     * @param fullName of the Artist
     * @param charactersDesigned of the Artist
     */
    public Artist(int artistId, String fullName, Set<MGSCharacter> charactersDesigned) {
        this.artistId = artistId;
        this.fullName = fullName;
        this.charactersDesigned = charactersDesigned;
    }

    /**
     * Getters and setters
     */

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<MGSCharacter> getCharactersDesigned() {
        return charactersDesigned;
    }

    public void setCharactersDesigned(Set<MGSCharacter> charactersDesigned) {
        this.charactersDesigned = charactersDesigned;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Artist artist = (Artist) object;
        return artistId == artist.artistId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistId);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", fullName='" + fullName + '\'' +
                ", charactersDesigned=" + charactersDesigned +
                '}';
    }
}
