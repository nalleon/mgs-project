package es.ies.puerto.mgs.project.exception;

import java.util.Date;

public class ErrorDetails {
    /**
     * Properties
     */
    private Date timestamp;
    private String message;
    private String details;

    /**
     * Constructor of the class
     * @param timestamp of the error
     * @param message of the error
     * @param details of the error
     */
    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    /**
     * Getters
     */
    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}