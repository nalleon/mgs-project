package es.ies.puerto.mgs.project.model.entities;

import es.ies.puerto.mgs.project.model.documents.Weapon;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeaponTest extends TestUtilities {
    public static final int WEAPON_ID = 1;
    public static final String NAME = "nameTest";
    public static final String TYPE = "typeTest";
    Weapon weapon;

    @BeforeEach
    public void beforeEach(){
        weapon = new Weapon();
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
        Weapon equals = new Weapon(WEAPON_ID);
        Weapon notEquals = new Weapon(2, NAME, TYPE);
        String str = "str";
        Weapon nullObject = null;

        Assertions.assertTrue(weapon.equals(equals), MESSAGE_ERROR);
        Assertions.assertTrue(weapon.equals(weapon), MESSAGE_ERROR);
        Assertions.assertEquals(weapon.hashCode(), equals.hashCode(), MESSAGE_ERROR);
        Assertions.assertEquals(weapon, equals, MESSAGE_ERROR);
        Assertions.assertFalse(weapon.equals(nullObject), MESSAGE_ERROR);
        Assertions.assertFalse(weapon.equals(notEquals), MESSAGE_ERROR);
        Assertions.assertFalse(weapon.equals(str), MESSAGE_ERROR);
    }
}
