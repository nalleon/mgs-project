package es.ies.puerto.mgs.project.utils;

import es.ies.puerto.mgs.project.model.documents.Weapon;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomApiResponseTest extends TestUtilities {

    public static final int STATUS = 1;
    public static final String MESSAGE = "nameTest";
    public static final Weapon DATA = new Weapon(2);
    CustomApiResponse<Weapon> response;

    @BeforeEach
    public void beforeEach(){
        response = new CustomApiResponse<Weapon>(2, "", new Weapon());
    }

    @Test
    public void getSetTest(){
        response.setStatus(STATUS);
        response.setMessage(MESSAGE);
        response.setData(DATA);
        Assertions.assertEquals(STATUS, response.getStatus(), MESSAGE_ERROR);
        Assertions.assertEquals(MESSAGE, response.getMessage(), MESSAGE_ERROR);
        Assertions.assertEquals(DATA, response.getData(), MESSAGE_ERROR);
    }

}
