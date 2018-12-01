package lesson35.demo;

import lesson35.controller.UserController;
import lesson35.model.User;
import lesson35.model.UserType;

/**
 * Created by Valik on 05.11.2018.
 */
public class DemoUser {
    public static void main(String[] args) throws Exception {
        UserController userController = new UserController();
        userController.registerUser(new User("Grisha", "222315", "Ukrain", UserType.USER));
    }
}
