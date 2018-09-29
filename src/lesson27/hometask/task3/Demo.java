package lesson27.hometask.task3;

import java.util.Arrays;

/**
 * Created by Valik on 21.09.2018.
 */
public class Demo {
    public static void main(String[] args) {

        User user1 = new User(1001, "Daniil", "2323534sdfsdfhjjjj");
        UserRepository.save(user1);

        System.out.println(UserRepository.getUsers());

        User user2 = new User(1002, "Andrey", "wehyghygfsd32123");
        UserRepository.save(user2);

        System.out.println(UserRepository.getUsers());

        User user3 = new User(1001, "Test", "2323534sdfsdfhjjjj");
        UserRepository.update(user3);

        System.out.println(UserRepository.getUsers());

        System.out.println(UserRepository.getUsers());



    }
}
