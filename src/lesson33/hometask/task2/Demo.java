package lesson33.hometask.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Valik on 26.10.2018.
 */
public class Demo {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, enter file path to read");
        try {
            Solution.readFileByConsolePath(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
