package pro.sky.exceptions;

public class InvalidIndexInputException extends RuntimeException {
    public InvalidIndexInputException(String message) {
        super(message);
    }

    public InvalidIndexInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIndexInputException(Throwable cause) {
        super(cause);
    }

    public InvalidIndexInputException() {
    }
}
