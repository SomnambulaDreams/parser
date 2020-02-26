package utils.exceptions;

public class DbClientException extends Exception {

    public DbClientException() {
    }

    public DbClientException(String message) {
        super(message);
    }

    public DbClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public DbClientException(Throwable cause) {
        super(cause);
    }

    public DbClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}