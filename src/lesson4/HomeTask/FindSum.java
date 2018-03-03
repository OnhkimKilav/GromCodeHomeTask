package lesson4.HomeTask;

/**
 * Created by Valik on 02.02.2018.
 */
public class FindSum {

    public static void main(String[] args) {
        System.out.println(compareSums(2, 6, 2, 5));
    }

    public static boolean compareSums(int a, int b, int c, int d) {
        boolean value = sum(a, b) > sum(c, d) ? true : false;
        return value;
    }

    public static long sum(int from, int to) {
        long sum = 0;
        for (long i = from; i <= to; i++) {
            sum += i;
        }
        return sum;
    }
}
