package lesson27.hometask.task3;

import java.util.ArrayList;

/**
 * Created by Valik on 25.02.2018.
 */
public class UserRepository {
    private static ArrayList<User> userArrayList = new ArrayList<>();

    public static ArrayList<User> getUsers() {
        return userArrayList;
    }

    public static int countUsers() {
        int count = 0;
        int index = 0;
        for (User user : userArrayList) {
            if (userArrayList.get(index) != null)
                count++;
            index++;
        }
        return count;
    }

    public static ArrayList<String> getUserNames() {
        ArrayList<String> userNames = new ArrayList<>();

        for (User user : userArrayList) {
            userNames.add(user.getName());
        }

        return userNames;
    }

    public static ArrayList<Long> getUserIds() {
        ArrayList<Long> userIds = new ArrayList<>();

        for (User user : userArrayList) {
            userIds.add(user.getId());
        }
        return userIds;
    }

    public static String getUserNameById(long id) {
        String name = null;

        for (User user : userArrayList) {
            if (user.getId() == id)
                name = user.getName();
        }
        return name;
    }

    public static User getUserByName(String name) {
        User userByName = null;

        for (User user : userArrayList) {
            if (user.getName() == name)
                userByName = user;
        }

        if (userByName == null)
            return null;
        return userByName;
    }

    public static User getUserById(long id) {
        User userById = null;

        for (User user : userArrayList) {
            if (user.getId() == id)
                userById = user;
        }

        if (userById == null)
            return null;
        return userById;
    }

    public static User getUserBySessionId(String sessionId) {
        User userBySessionId = null;

        for (User user : userArrayList) {
            if (user.getSessionId() == sessionId)
                userBySessionId = user;
        }

        if (userBySessionId == null)
            return null;
        return userBySessionId;
    }

    public static User save(User user) {
        if (user == null)
            return null;

        if (findById(user.getId()) != null)
            return null;

        userArrayList.add(user);

        return userArrayList.get(userArrayList.indexOf(user));
    }

    public static User findById(long id) {
        User userById = null;

        for (User user : userArrayList) {
            if (user.getId() == id)
                userById = user;
        }

        if (userById == null)
            return null;
        return userById;
    }

    public static User update(User user) {

        if (user == null)
            return null;

        if (findById(user.getId()) == null)
            return null;

        int index = 0;

        for (User us : userArrayList) {
            if (us.getId() == user.getId()) {
                userArrayList.set(index, user);
                return user;
            }
            index++;
        }
        return null;
    }

    public static void delete(long id) {
        int index = 0;
        for (User user : userArrayList) {
            if (user == findById(id))
                userArrayList.remove(index);
            index++;
        }
    }
}
