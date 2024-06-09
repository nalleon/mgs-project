package es.ies.puerto.mgs.project.model.entities;

import java.util.Objects;

/**
 * @author nalleon
 *
 * --> For MongoDB
 */
public class Weapon {
    /**
     * Properties
     */
    String name;
    String type;

    /**
     * Default constructor of the class
     */
    public Weapon() {
    }

    /**
     * Constructor of the class
     * @param name of the Weapon
     */
    public Weapon(String name) {
        this.name = name;
    }

    /**
     * Full constructor of the class
     * @param name of the Weapon
     * @param type of the Weapon
     */
    public Weapon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Getters and setters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return Objects.equals(name, weapon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
