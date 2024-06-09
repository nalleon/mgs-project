package es.ies.puerto.mgs.project.model.entities;
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

    /**
     * Default constructor of the class
     */
    public Weapon() {
    }

    /**
     * Constructor of the class
     * @param id
     */
    public Weapon(int id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param name
     */

    public Weapon(int id, String name) {
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
}
