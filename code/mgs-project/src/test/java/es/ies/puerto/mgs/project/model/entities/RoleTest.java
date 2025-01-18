package es.ies.puerto.mgs.project.model.entities;

import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoleTest extends TestUtilities {
    public static final int ROLE_ID = 1;
    public static final String NAME = "nameTest";
    Role role;

    @BeforeEach
    public void beforeEach(){
        role = new Role();
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
    public void equalsTest() {
        Role equals = new Role(ROLE_ID, NAME);
        Role differentName = new Role(ROLE_ID, "DifferentName");
        Role differentId = new Role(2, NAME);
        Role completelyDifferent = new Role(3, "AnotherName");
        String str = "str";
        Role nullObject = null;

        Assertions.assertEquals(role, equals, MESSAGE_ERROR);
        Assertions.assertEquals(role, role, MESSAGE_ERROR);
        Assertions.assertEquals(role.hashCode(), equals.hashCode(), MESSAGE_ERROR);
        Assertions.assertNotEquals(role, differentName, MESSAGE_ERROR);
        Assertions.assertNotEquals(role, differentId, MESSAGE_ERROR);
        Assertions.assertNotEquals(role, completelyDifferent, MESSAGE_ERROR);
        Assertions.assertNotEquals(role, nullObject, MESSAGE_ERROR);
        Assertions.assertNotEquals(role, str, MESSAGE_ERROR);
    }

}
