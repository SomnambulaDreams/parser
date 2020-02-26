package utils.exceptions;


public class PropertyFileException extends Exception {

    public PropertyFileException() {
        super();
    }

    public PropertyFileException(String message) {
        super(message);
    }

    public PropertyFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertyFileException(Throwable cause) {
        super(cause);
    }

    public PropertyFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}