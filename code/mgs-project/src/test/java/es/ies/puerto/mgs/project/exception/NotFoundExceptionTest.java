package es.ies.puerto.mgs.project.exception;

import org.junit.jupiter.api.Test;

public class NotFoundExceptionTest {

    public NotFoundException thrown;
    @Test
    public void exceptionTest(){
        thrown = new NotFoundException(NotFoundException.MESSAGE_ERROR);
    }
}
