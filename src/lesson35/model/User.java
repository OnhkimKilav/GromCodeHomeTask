package lesson35.model;

import java.util.Random;

/**
 * Created by Valik on 05.11.2018.
 */
public class User {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType type;

    private Random random = new Random();

    public User(String userName, String password, String country, UserType type) {
        this.id = random.nextLong();
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.type = type;
    }

    public User(long id, String userName, String password, String country, UserType type) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getType() {
        return type;
    }

    @Override
    public String toString() {
        return id + ", " + userName + ", " + password + ", " + country + ", " + type + "\n";
    }
}
