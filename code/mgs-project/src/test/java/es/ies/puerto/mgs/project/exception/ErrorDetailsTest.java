package es.ies.puerto.mgs.project.exception;

import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class ErrorDetailsTest extends TestUtilities {
    public static final String DETAILS_TEST = "detailsTest";
    public static final String MESSAGE_TEST = "messageTest";
    public static final Date TIMESTAMP = new Date();
    public ErrorDetails thrown;

    @Test
    public void constructorTest(){
        thrown = new ErrorDetails(TIMESTAMP, MESSAGE_TEST, DETAILS_TEST);
    }

    @Test
    public void gettersTest(){
        thrown = new ErrorDetails(TIMESTAMP, MESSAGE_TEST, DETAILS_TEST);

        Assertions.assertEquals(TIMESTAMP, thrown.getTimestamp(), MESSAGE_ERROR);
        Assertions.assertEquals(MESSAGE_TEST, thrown.getMessage(), MESSAGE_ERROR);
        Assertions.assertEquals(DETAILS_TEST, thrown.getDetails(), MESSAGE_ERROR);

    }
}
