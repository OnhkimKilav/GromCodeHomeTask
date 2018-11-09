package lesson35;

import lesson35.exception.UserLogInException;
import lesson35.user.User;
import lesson35.user.UserService;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;

/**
 * Created by Valik on 07.11.2018.
 */
public class Validate {

    public static void validateFileRead(File path) throws Exception {
        if (!path.exists())
            throw new FileNotFoundException("File " + path + " does not exist");
        if (!path.canRead())
            throw new Exception("File " + path + " does not have permissions to be read");
    }

    public static void validateFileWrite(File path) throws Exception {
        if (!path.exists())
            throw new FileNotFoundException("File " + path + " does not exist");
        if (!path.canWrite())
            throw new Exception("File " + path + " does not have permissions to be written");
    }

    public static void validateUserLogIn() throws UserLogInException {
        if (UserService.userLogName == null)
            throw new UserLogInException("Login to use this feature");
    }
}
