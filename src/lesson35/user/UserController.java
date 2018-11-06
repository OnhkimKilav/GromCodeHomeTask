package lesson35.user;

/**
 * Created by Valik on 05.11.2018.
 */
public class UserController {
    private UserService userService = new UserService();

    public User registerUser(User user){
        return userService.registerUser(user);
    }
}
