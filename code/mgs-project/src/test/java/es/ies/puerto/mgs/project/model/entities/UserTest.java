package es.ies.puerto.mgs.project.model.entities;

import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest extends TestUtilities {
    public static final int USER_ID = 1;
    public static final String NAME = "nameTest";
    public static final String EMAIL = "email@email.com";
    public static final String PASSWORD = "password";
    public static final Role ROLE = new Role(1, "Admin");
    User user;

    @BeforeEach
    public void beforeEach(){
        user = new User();
        user.setId(USER_ID);
        user.setName(NAME);
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);
        user.setRole(ROLE);
    }

    @Test
    public void getSetTest(){
        Assertions.assertEquals(USER_ID, user.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(NAME, user.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(EMAIL, user.getEmail(), MESSAGE_ERROR);
        Assertions.assertEquals(PASSWORD, user.getPassword(), MESSAGE_ERROR);
        Assertions.assertEquals(ROLE, user.getRole(), MESSAGE_ERROR);
    }

    @Test
    public void toStringTest(){
        Assertions.assertTrue(user.toString().contains(String.valueOf(USER_ID)), MESSAGE_ERROR);
        Assertions.assertTrue(user.toString().contains(NAME), MESSAGE_ERROR);
        Assertions.assertTrue(user.toString().contains(EMAIL), MESSAGE_ERROR);
        Assertions.assertFalse(user.toString().contains(PASSWORD), MESSAGE_ERROR);
        Assertions.assertTrue(user.toString().contains(ROLE.getName()), MESSAGE_ERROR);
    }

    @Test
    public void equalsTest(){
        User equals = new User(USER_ID, EMAIL);
        User notEquals = new User(2, "anotheremail@gmail.com");
        String str = "str";
        User nullObject = null;

        Assertions.assertTrue(user.equals(equals), MESSAGE_ERROR);
        Assertions.assertTrue(user.equals(user), MESSAGE_ERROR);
        Assertions.assertEquals(user.hashCode(), equals.hashCode(), MESSAGE_ERROR);
        Assertions.assertEquals(user, equals, MESSAGE_ERROR);
        Assertions.assertFalse(user.equals(nullObject), MESSAGE_ERROR);
        Assertions.assertFalse(user.equals(notEquals), MESSAGE_ERROR);
        Assertions.assertFalse(user.equals(str), MESSAGE_ERROR);
    }
}
