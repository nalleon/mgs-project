package es.ies.puerto.mgs.project.utils;
/**
 * @author Nabil Leon Alvarez <@nalleon>
 */
public class CustomApiResponse<T> {
    /**
     * Properties
     */
    private int status;
    private String message;
    private T data;

    /**
     * Full constructor of the class
     * @param status of the petititon
     * @param message of the petititon
     * @param data of the petititon
     */
    public CustomApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * Getters and setters
     */
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
