package es.ies.puerto.mgs.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception{
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE_ERROR = "Resource not found";
    public NotFoundException(String message){
        super(message);
    }
}
