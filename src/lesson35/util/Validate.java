package lesson35.util;

import lesson35.exception.UserLogInException;
import lesson35.exception.UserNotAdminException;
import lesson35.model.User;
import lesson35.service.UserService;
import lesson35.model.UserType;

import java.io.File;
import java.io.FileNotFoundException;

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
        if (UserService.logInUser == null)
            throw new UserLogInException("Login to use this feature");
    }

    public static void validateUserType(User user) throws UserNotAdminException {
        if (!user.getType().equals(UserType.ADMIN))
            throw new UserNotAdminException("User " + user.getId() + " doesn't admin. You can't use this feature");
    }
}
