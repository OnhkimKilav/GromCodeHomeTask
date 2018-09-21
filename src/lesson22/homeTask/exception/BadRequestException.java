package lesson22.homeTask.exception;

/**
 * Created by Valik on 18.09.2018.
 */
public class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }
}
