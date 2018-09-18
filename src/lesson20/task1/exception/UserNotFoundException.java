package lesson20.task1.exception;

/**
 * Created by Valik on 18.09.2018.
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
