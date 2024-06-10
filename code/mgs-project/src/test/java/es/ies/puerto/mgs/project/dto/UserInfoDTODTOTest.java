package es.ies.puerto.mgs.project.dto;

import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserInfoDTODTOTest extends TestUtilities {
    UserInfoDTO userInfoDTO;
    public static final String USERNAME = "usernameTest";
    public static final String PASSWORD = "password12345";

    @BeforeEach
    public void beforeEach(){
        userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUsername(USERNAME);
        userInfoDTO.setPassword(PASSWORD);
    }

    @Test
    public void getSetTest(){
        Assertions.assertEquals(USERNAME, userInfoDTO.getUsername(), MESSAGE_ERROR);
        Assertions.assertEquals(PASSWORD, userInfoDTO.getPassword(), MESSAGE_ERROR);
    }

    @Test
    public void toStringTest(){
        Assertions.assertTrue(userInfoDTO.toString().contains(PASSWORD), MESSAGE_ERROR);
        Assertions.assertTrue(userInfoDTO.toString().contains(USERNAME), MESSAGE_ERROR);
    }

    @Test
    public void equalsTest(){
        UserInfoDTO equals = new UserInfoDTO(USERNAME);
        UserInfoDTO notEquals = new UserInfoDTO("username_2", PASSWORD);
        String str = "str";
        UserInfoDTO nullObject = null;

        Assertions.assertTrue(userInfoDTO.equals(equals), MESSAGE_ERROR);
        Assertions.assertEquals(userInfoDTO.hashCode(), equals.hashCode(), MESSAGE_ERROR);
        Assertions.assertEquals(userInfoDTO, equals, MESSAGE_ERROR);
        Assertions.assertFalse(userInfoDTO.equals(nullObject), MESSAGE_ERROR);
        Assertions.assertFalse(userInfoDTO.equals(notEquals), MESSAGE_ERROR);
        Assertions.assertFalse(userInfoDTO.equals(str), MESSAGE_ERROR);
    }
}
