package lesson5.HomeTask;

import java.util.Arrays;

/**
 * Created by Valik on 04.02.2018.
 */
public class SortingByArray {
    public static void main(String[] args) {
        int[] array = {12, 5, 2, 65, 3, 87, 1, 0, 32, 4, 1, 76, 7};
        System.out.println(Arrays.toString(sortAscending(array)));
        System.out.println(Arrays.toString(sortDescending(array)));
    }


    public static int[] sortAscending(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int point = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = point;
                }
            }
        }
        return array;
    }


    public static int[] sortDescending(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int point = array[i];
                    array[i] = array[j];
                    array[j] = point;
                }
            }
        }
        return array;
    }
}
