package lesson15.homeTask.firstTask;

import java.util.Arrays;

/**
 * Created by Valik on 21.04.2018.
 */
public class Demo {
    public static void main(String[] args) {
        User user = new User(1001, "Ann", "5555");
        UserRepository userRepository = new UserRepository();
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        System.out.println(userRepository.save(user));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        System.out.println(userRepository.save(user));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        System.out.println();

        user = new User(1001, "Ann", "sdasdasd");
        userRepository.update(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
    }
}
