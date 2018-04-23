package lesson15.homeTask.firstTask;

/**
 * Created by Valik on 21.04.2018.
 */
public class UserRepository {
    private User[] users = new User[10];

    public User[] getUsers() {
        return users;
    }

    public User save(User user) {
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

    public User update(User user) {
        if (user == null)
            return null;

        if (findById(user.getId()) == null)
            return null;

        int index = 0;
        for (User user1 : users) {
            if (user1.getId() == user.getId() && !user1.equals(user)) {
                users[index] = user;
                return user;
            }
            index++;
        }
        return null;
    }

    public void delete(long id) {
        int index = 0;
        for (User user : users) {
            if (user.equals(user.getId()))
                users[index] = null;
            index++;
        }
    }

    public User findById(long id) {
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
}
