package es.ies.puerto.mgs.project.dto;

import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;

import java.util.Objects;
import java.util.Set;

/**
 * @author nalleon
 */
public class ArtistDTO {
    /**
     * Properties
     */
    int artistId;
    String fullName;
    Set<MGSCharacter> charactersDesigned;

    /**
     * Default constructor of the class
     */
    public ArtistDTO() {
    }

    /**
     * Constructor of the class
     * @param artistId of the Artist
     */
    public ArtistDTO(int artistId) {
        this.artistId = artistId;
    }

    /**
     * Full constructor of the class
     * @param artistId of the Artist
     * @param fullName of the Artist
     * @param charactersDesigned of the Artist
     */
    public ArtistDTO(int artistId, String fullName, Set<MGSCharacter> charactersDesigned) {
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
        ArtistDTO artist = (ArtistDTO) object;
        return artistId == artist.artistId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistId);
    }

    @Override
    public String toString() {
        return "ArtistDTO{" +
                "artistId=" + artistId +
                ", fullName='" + fullName + '\'' +
                ", charactersDesigned=" + charactersDesigned +
                '}';
    }
}
