package lesson35.user;

import java.util.Random;
import static java.lang.Integer.MAX_VALUE;

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
        this.id = random.nextInt(MAX_VALUE);
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
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", type=" + type +
                '}';
    }
}
