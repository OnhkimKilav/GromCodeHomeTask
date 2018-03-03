package Lesson9.HomeTask;

/**
 * Created by Valik on 25.02.2018.
 */
public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        if (users == null)
            return null;
        else {
            String[] userNames = new String[users.length];
            for (int i = 0; i < users.length; i++)
                userNames[i] = users[i].getName();
            return userNames;
        }
    }

    public long[] getUserIds() {
        long[] userIds = new long[users.length];
        for (int i = 0; i < users.length; i++) {
            userIds[i] = users[i].getId();
        }
        return userIds;
    }

    public String getUserNameById(long id) {
        String name = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id)
                name = users[i].getName();
        }
        return name;
    }
}
