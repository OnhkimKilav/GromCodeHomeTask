package Lesson8.ads;

/**
 * Created by Valik on 17.02.2018.
 */
public class User extends BaseEntity {
    String userName;
    String location;

    public User(long id, String userName, String location) {
        super(id);
        this.userName = userName;
        this.location = location;
    }
}
