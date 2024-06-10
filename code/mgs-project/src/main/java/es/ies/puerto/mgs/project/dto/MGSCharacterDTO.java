package es.ies.puerto.mgs.project.dto;

import java.util.Objects;

/**
 * @author nalleon
 */
public class MGSCharacterDTO {
    /**
     * Properties
     */
    int id;
    String name;
    String codename;
    int age;
    boolean status;

    /**
     * Default constructor of the class
     */
    public MGSCharacterDTO() {
    }

    /**
     * Constructor of the class
     * @param id of the MGSCharacter
     */
    public MGSCharacterDTO(int id) {
        this.id = id;
    }

    /**
     * Full constructor of the class
     * @param id of the MGSCharacter
     * @param codename of the MGSCharacter
     * @param age of the MGSCharacter
     * @param status of the MGSCharacter
     * @param name of the MGSCharacter
     */

    public MGSCharacterDTO(int id, String name, String codename, int age, boolean status) {
        this.id = id;
        this.name = name;
        this.codename = codename;
        this.age = age;
        this.status = status;
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

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MGSCharacterDTO that = (MGSCharacterDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "MGSCharacterDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", codename=" + codename +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}
