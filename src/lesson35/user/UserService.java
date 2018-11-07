package lesson35.user;

import lesson35.exception.UserNotRegisterException;

/**
 * Created by Valik on 05.11.2018.
 */
public class UserService {
    private UserDAO userDAO = new UserDAO();
    public static boolean userLog = false;

    public User registerUser(User user) throws Exception {
        //check business logic
        //нет пустых значений

        checkNull(user.getCountry(), user);
        checkNull(user.getPassword(), user);
        checkNull(user.getType(), user);
        checkNull(user.getUserName(), user);

        return userDAO.registerUser(user);
    }

    public void logIn(String userName, String password) throws Exception {
        //прочитать всех юзеров с файла
        //проверить есть ли на файле юзер с таким именем и паролем

        String userContent = userDAO.logIn().toString();
        String[] users = userContent.split("\n");

        StringBuffer res = new StringBuffer();
        int index = 0;
        for (String user : users) {
            String[] valuesUser = user.split(", ");
            if (valuesUser[1].equals(userName) && valuesUser[2].equals(password)) {
                userLog = true;
                break;
            } else if (index == users.length - 1)
                throw new UserNotRegisterException("User wasn't register. Or you aren't correct writing a password or an user name");
            index++;
        }
    }

    private <T> void checkNull(T t, User user) {
        if (t == null)
            throw new IllegalArgumentException("User " + user.getId() + " can't have null");
    }
}
