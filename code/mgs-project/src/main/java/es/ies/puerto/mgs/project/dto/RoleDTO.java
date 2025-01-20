package es.ies.puerto.mgs.project.dto;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

/**
 * @author nalleon
 */
public class RoleDTO {

    private int id;
    private String name;

    /**
     * Default constructor of the class
     */
    public RoleDTO() {}

    /**
     * Full constructor of the clss
     * @param id of the user
     * @param name of the user
     */
    public RoleDTO(int id, String name) {
        this.id = id;
        this.name = name;
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

    /**
     * ToString
     */
    @Override
    public String toString() {
        return "RoleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Equals and hashcode
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDTO role = (RoleDTO) o;
        return id == role.id && Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
