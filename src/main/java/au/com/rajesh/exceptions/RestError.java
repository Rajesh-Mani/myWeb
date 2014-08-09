package au.com.rajesh.exceptions;

public class RestError {

    private int status;
    private String code;
    private String message;
    private String developerMessage;

    public RestError(int status, String code, String message, String developerMessage) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.developerMessage = developerMessage;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }
}
