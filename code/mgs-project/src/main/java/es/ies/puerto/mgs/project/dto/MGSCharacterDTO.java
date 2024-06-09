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
    String name;
    Codename codename;
    int age;
    boolean status;

    /**
     * Default constructor of the class
     */
    public MGSCharacterDTO() {
    }

    /**
     * Constructor of the class
     * @param name of the MGSCharacter
     */
    public MGSCharacterDTO(String name) {
        this.name = name;
    }

    /**
     * Full constructor of the class
     * @param codename of the MGSCharacter
     * @param age of the MGSCharacter
     * @param status of the MGSCharacter
     * @param name of the MGSCharacter
     */
    public MGSCharacterDTO(Codename codename, int age, boolean status, String name) {
        this.codename = codename;
        this.age = age;
        this.status = status;
        this.name = name;
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

    public Codename getCodename() {
        return codename;
    }

    public void setCodename(Codename codename) {
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
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "MGSCharacterDTO{" +
                "name='" + name + '\'' +
                ", codename=" + codename +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}
