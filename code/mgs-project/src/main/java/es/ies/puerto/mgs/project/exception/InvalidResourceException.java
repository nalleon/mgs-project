package es.ies.puerto.mgs.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class InvalidResourceException extends Exception {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE_ERROR = "Invalid resource";
    public InvalidResourceException(String message){
        super(message);
    }
}
