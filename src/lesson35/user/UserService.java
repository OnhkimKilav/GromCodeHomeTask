package lesson35.user;

import lesson35.Validate;
import lesson35.exception.UserLogInException;
import lesson35.exception.UserNotRegisterException;

/**
 * Created by Valik on 05.11.2018.
 */
public class UserService {
    private UserDAO userDAO = new UserDAO();
    public static String userLogName = null;

    public User registerUser(User user) throws Exception {
        //check business logic
        //нет пустых значений

        Validate.checkNull(user.getCountry(), user);
        Validate.checkNull(user.getPassword(), user);
        Validate.checkNull(user.getType(), user);
        Validate.checkNull(user.getUserName(), user);

        return userDAO.registerUser(user);
    }

    public void logIn(String userName, String password) throws Exception {
        //прочитать всех юзеров с файла
        //проверить есть ли на файле юзер с таким именем и паролем
        if(userName == null)
            throw new IllegalArgumentException("User name can't be null");
        if(password == null)
            throw new IllegalArgumentException("Password can't be null");
        if(userLogName != null)
            throw new UserLogInException("User " + userLogName + " is currently logged in");

        String userContent = userDAO.logIn().toString();
        String[] users = userContent.split("\n");

        StringBuffer res = new StringBuffer();
        int index = 0;
        for (String user : users) {
            String[] valuesUser = user.split(", ");
            if (valuesUser[1].equals(userName) && valuesUser[2].equals(password)) {
                userLogName = userName;
                break;
            } else if (index == users.length - 1)
                throw new UserNotRegisterException("User wasn't register. Or you aren't correct writing a password or an user name");
            index++;
        }
    }

    public void logOut(){
        if(userLogName != null)
            userLogName = null;
    }
}
