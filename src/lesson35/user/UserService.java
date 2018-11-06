package lesson35.user;

/**
 * Created by Valik on 05.11.2018.
 */
public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User registerUser(User user) {
        //check business logic
        //нет пустых значений

        checkNull(user.getCountry(), user);
        checkNull(user.getPassword(), user);
        checkNull(user.getType(), user);
        checkNull(user.getUserName(), user);

        return userDAO.registerUser(user);
    }

    private<T> void checkNull(T t, User user){
        if(t == null)
            throw new IllegalArgumentException("User " + user.getId() + " can't have null");
    }
}
