package lesson35.demo;

import lesson35.controller.UserController;

/**
 * Created by Valik on 05.11.2018.
 */
public class DemoUser {
    public static void main(String[] args) throws Exception {
        UserController userController = new UserController();
        userController.logIn("Masha", "53421");
    }
}
