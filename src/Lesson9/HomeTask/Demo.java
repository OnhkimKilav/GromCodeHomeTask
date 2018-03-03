package Lesson9.HomeTask;

/**
 * Created by Valik on 25.02.2018.
 */
public class Demo {
    public static void main(String[] args) {
        User[] users = new User[3];
        /*UserRepository userRepository = new UserRepository(users);
        for(int i=0; i < users.length; i ++)
            System.out.println(userRepository.getUserIds());
        System.out.println(userRepository.getUserNameById(10));
        System.out.println(userRepository.getUserNames());*/

        UserRepository userRepository = new UserRepository(users);

        users[0] = new User(10, "Jim", "sa");
        users[1] = new User(11, "Tom", "sa");
        users[2] = new User(16, "Den", "sa");

        System.out.println(userRepository.getUserNames());
    }
}
