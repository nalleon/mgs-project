package es.ies.puerto.mgs.project.dto;

import es.ies.puerto.mgs.project.model.entities.Weapon;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeaponDTOTest extends TestUtilities {
    public static final int WEAPON_ID = 1;
    public static final String NAME = "nameTest";
    public static final String TYPE = "typeTest";
    WeaponDTO weapon;

    @BeforeEach
    public void beforeEach(){
        weapon = new WeaponDTO();
        weapon.setId(WEAPON_ID);
        weapon.setName(NAME);
        weapon.setType(TYPE);
    }

    @Test
    public void getSetTest(){
        Assertions.assertEquals(WEAPON_ID, weapon.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(NAME, weapon.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(TYPE, weapon.getType(), MESSAGE_ERROR);
    }

    @Test
    public void toStringTest(){
        Assertions.assertTrue(weapon.toString().contains(String.valueOf(WEAPON_ID)), MESSAGE_ERROR);
        Assertions.assertTrue(weapon.toString().contains(NAME), MESSAGE_ERROR);
        Assertions.assertTrue(weapon.toString().contains(TYPE), MESSAGE_ERROR);
    }

    @Test
    public void equalsTest(){
        WeaponDTO equals = new WeaponDTO(WEAPON_ID);
        WeaponDTO notEquals = new WeaponDTO(2, NAME, TYPE);
        String str = "str";
        WeaponDTO nullObject = null;

        Assertions.assertTrue(weapon.equals(equals), MESSAGE_ERROR);
        Assertions.assertTrue(weapon.equals(weapon), MESSAGE_ERROR);
        Assertions.assertEquals(weapon.hashCode(), equals.hashCode(), MESSAGE_ERROR);
        Assertions.assertEquals(weapon, equals, MESSAGE_ERROR);
        Assertions.assertFalse(weapon.equals(nullObject), MESSAGE_ERROR);
        Assertions.assertFalse(weapon.equals(notEquals), MESSAGE_ERROR);
        Assertions.assertFalse(weapon.equals(str), MESSAGE_ERROR);
    }
}
