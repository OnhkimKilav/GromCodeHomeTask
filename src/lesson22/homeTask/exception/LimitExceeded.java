package lesson22.homeTask.exception;

/**
 * Created by Valik on 18.09.2018.
 */
public class LimitExceeded extends BadRequestException {
    public LimitExceeded(String message) {
        super(message);
    }
}
