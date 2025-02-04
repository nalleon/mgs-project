package es.ies.puerto.mgs.project.dto;

import es.ies.puerto.mgs.project.dto.outputs.RoleDTO;
import es.ies.puerto.mgs.project.dto.outputs.UserDTO;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserDTOTest extends TestUtilities {
    public static final int USER_ID = 1;
    public static final String NAME = "nameTest";
    public static final String EMAIL = "email@email.com";
    public static final String PASSWORD = "password";
    public static final RoleDTO ROLE = new RoleDTO(1, "Admin");
    UserDTO user;

    @BeforeEach
    public void beforeEach(){
        user = new UserDTO();
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
        Assertions.assertTrue(user.toString().contains(ROLE.toString()), MESSAGE_ERROR);
    }

    @Test
    public void equalsTest(){
        UserDTO equals = new UserDTO(USER_ID, EMAIL);
        UserDTO differentEmail = new UserDTO(USER_ID, "different@gmail.com");
        UserDTO differentId = new UserDTO(2, EMAIL);
        UserDTO completelyDifferent = new UserDTO(3, "another@gmail.com");
        String str = "str";
        UserDTO nullObject = null;

        Assertions.assertEquals(user, equals, MESSAGE_ERROR);
        Assertions.assertEquals(user, user, MESSAGE_ERROR);
        Assertions.assertEquals(user.hashCode(), equals.hashCode(), MESSAGE_ERROR);
        Assertions.assertNotEquals(user, differentEmail, MESSAGE_ERROR);
        Assertions.assertNotEquals(user, differentId, MESSAGE_ERROR);
        Assertions.assertNotEquals(user, completelyDifferent, MESSAGE_ERROR);
        Assertions.assertNotEquals(user, nullObject, MESSAGE_ERROR);
        Assertions.assertNotEquals(user, str, MESSAGE_ERROR);
    }
}
