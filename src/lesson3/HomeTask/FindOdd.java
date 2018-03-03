package lesson3.HomeTask;

/**
 * Created by User on 30.01.2018.
 */
public class FindOdd {
    public static void main(String[] args) {
        int a = 1000;
        int b = 0;
        int sum = 0;
        int max = 5000;
        while (b <= a) {
            if ((b%2)!=0)
                System.out.println("Found");
            sum += b;
            b++;
        }

        if ((sum * 5) > max)
            System.out.println("Bigger");
        else System.out.println("Smaller");
    }
}
