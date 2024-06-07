package es.ies.puerto.mgs.project.model.entities;

import java.util.Objects;

/**
 * @author nalleon
 */
public class Codename {
    /**
     * Properties
     */
    int codenameId;
    String codename;

    /**
     * Default constructor of the class
     */
    public Codename() {
    }

    /**
     * Constructor of the class
     * @param codenameId of the Codename
     */
    public Codename(int codenameId) {
        this.codenameId = codenameId;
    }

    /**
     * Full constructor of the class
     * @param codenameId of the Codename
     * @param codename of the Codename
     */
    public Codename(int codenameId, String codename) {
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
        Codename codename = (Codename) object;
        return codenameId == codename.codenameId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codenameId);
    }

    @Override
    public String toString() {
        return "Codename{" +
                "codenameId=" + codenameId +
                ", codename='" + codename + '\'' +
                '}';
    }
}
