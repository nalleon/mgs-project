package es.ies.puerto.mgs.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.Objects;

/**
 * @author nalleon
 */
public class ArtistDTO {
    /**
     * Properties
     */
    @JsonIgnore
    int artistId;
    String fullName;

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
     */
    public ArtistDTO(int artistId, String fullName) {
        this.artistId = artistId;
        this.fullName = fullName;
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
                '}';
    }
}
