package es.ies.puerto.mgs.project.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.Objects;

/**
 * @author nalleon
 */
public class DirectorDTO {
    /**
     * Properties
     */
    @JsonIgnore
    @XmlTransient
    int directorId;
    String fullName;

    /**
     * Default constructor of the class
     */
    public DirectorDTO() {
    }

    /**
     * Constructor of the class
     * @param directorId of the Director
     */

    public DirectorDTO(int directorId) {
        this.directorId = directorId;
    }

    /**
     * Full constructor of the class
     * @param directorId of the Director
     * @param fullName of the Director
     */

    public DirectorDTO(int directorId, String fullName) {
        this.directorId = directorId;
        this.fullName = fullName;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        DirectorDTO director = (DirectorDTO) object;
        return directorId == director.directorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(directorId);
    }

    @Override
    public String toString() {
        return "DirectorDTO{" +
                "directorId=" + directorId +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
