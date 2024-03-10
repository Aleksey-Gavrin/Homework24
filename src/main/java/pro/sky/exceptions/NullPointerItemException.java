package pro.sky.exceptions;

public class NullPointerItemException extends RuntimeException {
    public NullPointerItemException() {
    }

    public NullPointerItemException(String message) {
        super(message);
    }

    public NullPointerItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullPointerItemException(Throwable cause) {
        super(cause);
    }
}
