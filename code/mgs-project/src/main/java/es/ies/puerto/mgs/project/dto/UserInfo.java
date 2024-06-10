package es.ies.puerto.mgs.project.dto;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(username, userInfo.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
