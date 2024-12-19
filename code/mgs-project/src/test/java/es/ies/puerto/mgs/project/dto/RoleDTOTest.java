package es.ies.puerto.mgs.project.dto;

import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoleDTOTest extends TestUtilities {
    public static final int ROLE_ID = 1;
    public static final String NAME = "nameTest";
    RoleDTO role;

    @BeforeEach
    public void beforeEach(){
        role = new RoleDTO();
        role.setId(ROLE_ID);
        role.setName(NAME);
    }

    @Test
    public void getSetTest(){
        Assertions.assertEquals(ROLE_ID, role.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(NAME, role.getName(), MESSAGE_ERROR);
    }

    @Test
    public void toStringTest(){
        Assertions.assertTrue(role.toString().contains(String.valueOf(ROLE_ID)), MESSAGE_ERROR);
        Assertions.assertTrue(role.toString().contains(NAME), MESSAGE_ERROR);
    }

    @Test
    public void equalsTest(){
        RoleDTO equals = new RoleDTO(ROLE_ID, NAME);
        RoleDTO notEquals = new RoleDTO(2, "anotherName");
        String str = "str";
        RoleDTO nullObject = null;

        Assertions.assertTrue(role.equals(equals), MESSAGE_ERROR);
        Assertions.assertTrue(role.equals(role), MESSAGE_ERROR);
        Assertions.assertEquals(role.hashCode(), equals.hashCode(), MESSAGE_ERROR);
        Assertions.assertEquals(role, equals, MESSAGE_ERROR);
        Assertions.assertFalse(role.equals(nullObject), MESSAGE_ERROR);
        Assertions.assertFalse(role.equals(notEquals), MESSAGE_ERROR);
        Assertions.assertFalse(role.equals(str), MESSAGE_ERROR);
    }
}
