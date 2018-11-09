package lesson35.demo;

import lesson35.Validate;
import lesson35.user.User;
import lesson35.user.UserController;
import lesson35.user.UserType;

import java.io.File;

/**
 * Created by Valik on 05.11.2018.
 */
public class DemoUser {
    public static void main(String[] args) throws Exception {
        UserController userController = new UserController();
        userController.logIn("Masha", "53421");
        User user = new User("Valik",null, "hjas", UserType.USER);
        userController.registerUser(user);
    }
}
