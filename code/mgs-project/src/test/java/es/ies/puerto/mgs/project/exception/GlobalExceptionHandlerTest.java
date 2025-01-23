package es.ies.puerto.mgs.project.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GlobalExceptionHandlerTest {

    public GlobalExceptionHandler thrown;
    @Test
    public void exceptionTest(){
        thrown = new GlobalExceptionHandler();
    }
}
