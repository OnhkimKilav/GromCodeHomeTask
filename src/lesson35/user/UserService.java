package lesson35.user;

import lesson35.exception.UserLogInException;
import lesson35.exception.UserNotRegisterException;

import java.lang.reflect.Field;

/**
 * Created by Valik on 05.11.2018.
 */
public class UserService {
    private UserDAO userDAO = new UserDAO();
    public static String userLogName = null;

    public User registerUser(User user) throws Exception {
        //check business logic
        //нет пустых значений
        checkNull(user);
        checkUserName(user.getUserName());

        return userDAO.registerUser(user);
    }

    public void logIn(String userName, String password) throws Exception {
        //прочитать всех юзеров с файла
        //проверить есть ли на файле юзер с таким именем и паролем
        if (userName == null)
            throw new IllegalArgumentException("User name can't be null");
        if (password == null)
            throw new IllegalArgumentException("Password can't be null");
        if (userLogName != null)
            throw new UserLogInException("User " + userLogName + " is currently logged in");

        String userContent = userDAO.logIn().toString();
        String[] fileUsers = userContent.split("\n");

        StringBuffer res = new StringBuffer();
        int index = 0;

        for (String fileUser : fileUsers) {
            String[] valuesUser = fileUser.split(", ");
            User user = new User(Long.parseLong(valuesUser[0]), valuesUser[1], valuesUser[2], valuesUser[3], UserType.valueOf(valuesUser[4]));
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                userLogName = userName;
                break;
            } else if (index == fileUsers.length - 1)
                throw new UserNotRegisterException("User wasn't register. Or you aren't correct writing a password or an user name");

            index++;
        }
    }

    public void logOut() {
        if (userLogName != null)
            userLogName = null;
    }

    private void checkUserName(String userName) throws Exception {
        String userContent = userDAO.readFile().toString();
        String[] fileUsers = userContent.split("\n");

        StringBuffer res = new StringBuffer();

        for (String fileUser : fileUsers) {
            String[] valuesUser = fileUser.split(", ");
            User user = new User(Long.parseLong(valuesUser[0]), valuesUser[1], valuesUser[2], valuesUser[3], UserType.valueOf(valuesUser[4]));
            if(user.getUserName().equals(userName))
                throw new UserNotRegisterException(userName + " already in use. Use a different name");
        }
    }

    private boolean checkNull(User user) throws IllegalAccessException {
        for (Field f : getClass().getDeclaredFields())
            if (f.get(this) != null)
                throw new IllegalArgumentException("User " + user.getId() + "can't have null");
        return true;
    }
}
