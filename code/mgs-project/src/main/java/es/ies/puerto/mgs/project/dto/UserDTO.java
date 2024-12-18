package es.ies.puerto.mgs.project.dto;

import jakarta.persistence.*;

import java.util.Objects;


public class UserDTO {
    @Id
    private int id;
    private String name;
    private String email;
    private String password;
    private RoleDTO role;

    /**
     * Default constructor of the class
     */
    public UserDTO() {}

    /**
     * Constructor of the class
     * @param email of the user
     * @param password
     */
    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Getters and setters
     * @return
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id_role=" + role.getName() + '\''+
                '}';
    }

    /**
     * Equals and HashCode
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO user = (UserDTO) o;
        return id == user.id && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
