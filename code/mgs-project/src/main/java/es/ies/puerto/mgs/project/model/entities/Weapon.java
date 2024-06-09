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
    int id;
    String name;
    String type;

    /**
     * Default constructor of the class
     */
    public Weapon() {
    }

    /**
     * Constructor of the class
     * @param id of the Weapon
     */
    public Weapon(int id) {
        this.id = id;
    }

    /**
     * Full constructor of the class
     * @param id of the Weapon
     * @param name of the Weapon
     * @param type of the Weapon
     */

    public Weapon(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type=type;
    }

    /**
     * Getters and setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        return id == weapon.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
