package utils.exceptions;


public class DriverSetupException extends Exception {

    public DriverSetupException() {
    }

    public DriverSetupException(String message) {
        super(message);
    }

    public DriverSetupException(String message, Throwable cause) {
        super(message, cause);
    }

    public DriverSetupException(Throwable cause) {
        super(cause);
    }

    public DriverSetupException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}