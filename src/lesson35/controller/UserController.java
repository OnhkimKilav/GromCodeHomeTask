package lesson35.controller;

import lesson35.model.User;
import lesson35.service.UserService;

/**
 * Created by Valik on 05.11.2018.
 */
public class UserController {
    private UserService userService = new UserService();

    public User registerUser(User user) throws Exception {
        return userService.registerUser(user);
    }

    public void logIn(String userName, String password) throws Exception {
        userService.logIn(userName, password);
    }

    public void logOut(){
        userService.logOut();
    }
}
