package es.ies.puerto.mgs.project.exception;

import org.junit.jupiter.api.Test;

public class InvalidResourceExceptionTest {
    public InvalidResourceException thrown;
    @Test
    public void exceptionTest(){
        thrown = new InvalidResourceException(InvalidResourceException.MESSAGE_ERROR);
    }
}
