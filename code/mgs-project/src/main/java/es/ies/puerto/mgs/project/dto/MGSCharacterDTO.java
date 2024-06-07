package es.ies.puerto.mgs.project.dto;

import es.ies.puerto.mgs.project.model.entities.Codename;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;

import java.util.Objects;

/**
 * @author nalleon
 */
public class MGSCharacterDTO {
    /**
     * Properties
     */
    int mgsChracterId;
    String name;
    Codename codename;

    /**
     * Default constructor of the class
     */
    public MGSCharacterDTO() {
    }

    /**
     * Constructor of the class
     * @param mgsChracterId of the MGSCharacter
     */
    public MGSCharacterDTO(int mgsChracterId) {
        this.mgsChracterId = mgsChracterId;
    }

    /**
     * Full constructor of the class
     * @param mgsChracterId of the MGSCharacter
     * @param name of the MGSCharacter
     * @param codename of the MGSCharacter
     */
    public MGSCharacterDTO(int mgsChracterId, String name, Codename codename) {
        this.mgsChracterId = mgsChracterId;
        this.name = name;
        this.codename = codename;
    }

    /**
     * Getters and setters
     */

    public int getMgsChracterId() {
        return mgsChracterId;
    }

    public void setMgsChracterId(int mgsChracterId) {
        this.mgsChracterId = mgsChracterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Codename getCodename() {
        return codename;
    }

    public void setCodename(Codename codename) {
        this.codename = codename;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        MGSCharacterDTO that = (MGSCharacterDTO) object;
        return mgsChracterId == that.mgsChracterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mgsChracterId);
    }

    @Override
    public String toString() {
        return "MGSCharacterDTO{" +
                "mgsChracterId=" + mgsChracterId +
                ", name='" + name + '\'' +
                ", codename=" + codename +
                '}';
    }
}
