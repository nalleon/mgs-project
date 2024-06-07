package es.ies.puerto.mgs.project.dto;

import org.h2.engine.User;

/**
 * @author nalleon
 */
public class UserInfo {

    /**
     * Properties
     */
    String username;
    String password;

    /**
     * Default constructor of the class
     */
    public UserInfo (){}

    /**
     * Full constrcutor of the class
     * @param username
     * @param password
     */

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Getters and setters
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
