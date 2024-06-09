package es.ies.puerto.mgs.project.model.entities;

import java.util.Objects;

/**
 * @author nalleon
 */
public class Codename {
    /**
     * Properties
     */
    String codename;

    /**
     * Default constructor of the class
     */
    public Codename() {
    }

    /**
     * Constructor of the class
     * @param codename
     */

    public Codename(String codename) {
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
        Codename codename1 = (Codename) o;
        return Objects.equals(codename, codename1.codename);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codename);
    }

    @Override
    public String toString() {
        return "Codename{" +
                "codename='" + codename + '\'' +
                '}';
    }
}
