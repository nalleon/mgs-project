package es.ies.puerto.mgs.project.dto;

import es.ies.puerto.mgs.project.model.entities.Codename;

import java.util.Objects;

/**
 * @author nalleon
 */
public class CodenameDTO {
    /**
     * Properties
     */
    String codename;

    /**
     * Default constructor of the class
     */
    public CodenameDTO() {
    }

    /**
     * Full constructor of the class
     * @param codename of the Codename
     */
    public CodenameDTO(String codename) {
        this.codename = codename;
    }

    /**
     * Getters and setters
     */

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodenameDTO that = (CodenameDTO) o;
        return Objects.equals(codename, that.codename);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codename);
    }

    @Override
    public String toString() {
        return "CodenameDTO{" +
                "codename='" + codename + '\'' +
                '}';
    }
}
