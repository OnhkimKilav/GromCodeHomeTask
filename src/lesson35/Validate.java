package lesson35;

import lesson35.user.User;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Valik on 07.11.2018.
 */
public class Validate {
    public static <T> void checkNull(T t, User user) {
        if (t == null)
            throw new IllegalArgumentException("User " + user.getId() + " can't have null");
    }

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
}
