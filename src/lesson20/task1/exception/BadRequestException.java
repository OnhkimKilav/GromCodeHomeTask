package lesson20.task1.exception;

/**
 * Created by Valik on 18.09.2018.
 */
public class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }
}
