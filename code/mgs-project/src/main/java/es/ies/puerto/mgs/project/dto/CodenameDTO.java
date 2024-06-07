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
    int codenameId;
    String codename;

    /**
     * Default constructor of the class
     */
    public CodenameDTO() {
    }

    /**
     * Constructor of the class
     * @param codenameId of the Codename
     */
    public CodenameDTO(int codenameId) {
        this.codenameId = codenameId;
    }

    /**
     * Full constructor of the class
     * @param codenameId of the Codename
     * @param codename of the Codename
     */
    public CodenameDTO(int codenameId, String codename) {
        this.codenameId = codenameId;
        this.codename = codename;
    }

    /**
     * Getters and setters
     */
    public int getCodenameId() {
        return codenameId;
    }

    public void setCodenameId(int codenameId) {
        this.codenameId = codenameId;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CodenameDTO codename = (CodenameDTO) object;
        return codenameId == codename.codenameId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codenameId);
    }

    @Override
    public String toString() {
        return "CodenameDTO{" +
                "codenameId=" + codenameId +
                ", codename='" + codename + '\'' +
                '}';
    }
}
