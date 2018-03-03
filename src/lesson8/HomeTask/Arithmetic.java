package lesson8.HomeTask;

/**
 * Created by Valik on 18.02.2018.
 */
public class Arithmetic {
    boolean check(int[] array) {
        int maxValue = array[0];
        int minValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (maxValue < array[i])
                maxValue = array[i];
        }

        for (int i = 1; i < array.length; i++) {
            if (minValue > array[i])
                minValue = array[i];
        }

        int sum = maxValue + minValue;

        return sum > 100 ? true : false;
    }
}
