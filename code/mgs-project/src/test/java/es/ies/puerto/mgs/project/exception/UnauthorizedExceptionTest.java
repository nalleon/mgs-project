package es.ies.puerto.mgs.project.exception;

import org.junit.jupiter.api.Test;
public class UnauthorizedExceptionTest {

    public UnauthorizedException thrown;
    @Test
    public void exceptionTest(){
       thrown = new UnauthorizedException(UnauthorizedException.MESSAGE_ERROR);
    }
}
