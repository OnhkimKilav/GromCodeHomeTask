package Lesson4.HomeTask;

/**
 * Created by User on 01.02.2018.
 */
public class ConcatenationString {
    public static void main(String[] args) {
        System.out.println(concat("Java ", "it's ", "cool"));
    }

    public static String concat(String a, String b, String c) {
        String sum = a + b + c;
        return sum;
    }
}
