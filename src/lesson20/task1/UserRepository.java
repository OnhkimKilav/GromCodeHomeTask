package lesson20.task1;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServelException;
import lesson20.task1.exception.UserNotFoundException;

/**
 * Created by Valik on 18.09.2018.
 */
public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public int countUsers() {
        int count = 0;
        int index = 0;
        for (User user : users) {
            if (users[index] != null)
                count++;
            index++;
        }
        return count;
    }

    public String[] getUserNames() {
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

    public long[] getUserIds() {
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

    public String getUserNameById(long id) {
        String name = null;
        int index = 0;

        for (User user : users) {
            if (user != null)
                if (users[index].getId() == id)
                    name = users[index].getName();
        }
        return name;
    }

    public User getUserByName(String name) {
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

    public User getUserById(long id) {
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

    public User getUserBySessionId(String sessionId) {
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

    public User save(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        } catch (UserNotFoundException e) {
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }

        int index = 0;
        for (User us : users) {
            if (us == null) {
                users[index] = user;
                return users[index];
            }
            index++;
        }

        throw new InternalServelException("Not enough space to save user with id: " + user.getId());
    }

    public User findById(long id) throws UserNotFoundException {

        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }

        throw new UserNotFoundException("User with id: " + id + " not found");
    }

    public User update(User user) throws Exception {

        if (user == null)
            throw new BadRequestException("Can't update null user");

        findById(user.getId());

        int index = 0;

        for (User us : users) {
            if (us != null && us.getId() == user.getId()) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
        throw new InternalServelException("Unexpected error");
    }

    public void delete(long id) throws Exception {

        findById(id);

        int index = 0;
        for (User user : users) {
            if (user.getId() == id) {
                users[index] = null;
                break;
            }
            index++;
        }
    }
}

