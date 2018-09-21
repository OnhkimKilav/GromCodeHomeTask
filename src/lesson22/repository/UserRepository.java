package lesson22.repository;

/**
 * Created by Valik on 25.02.2018.
 */
public class UserRepository {
    private static User[] users = new User[10];

    public static User[] getUsers() {
        return users;
    }

    public static int countUsers() {
        int count = 0;
        int index = 0;
        for (User user : users) {
            if (users[index] != null)
                count++;
            index++;
        }
        return count;
    }

    public static String[] getUserNames() {
        String[] userNames = new String[countUsers()];

        int index = 0;
        for (User user : users) {
            if (user != null) {
                userNames[index] = user.getName();
                index++;
            }
        }

        return userNames;
    }

    public static long[] getUserIds() {
        long[] userIds = new long[countUsers()];

        int index = 0;
        for (User user : users) {
            if (user != null) {
                userIds[index] = users[index].getId();
                index++;
            }
        }
        return userIds;
    }

    public static String getUserNameById(long id) {
        String name = null;
        int index = 0;

        for (User user : users) {
            if (user != null)
                if (users[index].getId() == id)
                    name = users[index].getName();
        }
        return name;
    }

    public static User getUserByName(String name) {
        User userByName = null;
        int index = 0;

        for (User user : users) {
            if (user != null) {
                if (users[index].getName() == name)
                    userByName = users[index];
            }

            index++;
        }

        if (userByName == null)
            return null;
        return userByName;
    }

    public static User getUserById(long id) {
        User userById = null;
        int index = 0;

        for (User user : users) {
            if (user != null) {
                if (users[index].getId() == id)
                    userById = users[index];
            }

            index++;
        }

        if (userById == null)
            return null;
        return userById;
    }

    public static User getUserBySessionId(String sessionId) {
        User userBySessionId = null;
        int index = 0;

        for (User user : users) {
            if (user != null) {
                if (users[index].getSessionId() == sessionId)
                    userBySessionId = users[index];
            }

            index++;
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

        int index = 0;
        for (User us : users) {
            if (us == null) {
                users[index] = user;
                return users[index];
            }
            index++;
        }

        return null;
    }

    public static User findById(long id) {
        User userById = null;
        int index = 0;

        for (User user : users) {
            if (user != null) {
                if (users[index].getId() == id)
                    userById = users[index];
            }

            index++;
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

        for (User us : users) {
            if (us.getId() == user.getId()) {
                users[index] = user;
                return user;
            }
            index++;
        }
        return null;
    }

    public static void delete(long id) {
        int index = 0;
        for (User user : users) {
            if (user == findById(id))
                users[index] = null;
            index++;
        }
    }
}
