package es.ies.puerto.mgs.project.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.Objects;

/**
 * @author nalleon
 */
public class WeaponDTO {
    /**
     * Properties
     */
    @JsonIgnore
    @XmlTransient
    int id;
    String name;
    String type;

    /**
     * Default constructor of the class
     */
    public WeaponDTO() {
    }

    /**
     * Constructor of the class
     * @param id of the Weapon
     */
    public WeaponDTO(int id) {
        this.id = id;
    }

    /**
     * Full constructor of the class
     * @param id of the Weapon
     * @param name of the Weapon
     * @param type of the Weapon
     */
    public WeaponDTO(int id, String type, String name) {
        this.type = type;
        this.name = name;
        this.id = id;
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
        WeaponDTO weapon = (WeaponDTO) o;
        return id == weapon.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "WeaponDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
