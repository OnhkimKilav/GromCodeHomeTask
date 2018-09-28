package lesson26;

import java.util.ArrayList;

/**
 * Created by Valik on 26.09.2018.
 */
public class ArrayListExample {
    public static void main(String[] args) {
        int[] test = new int[5];
        test[0] = 10;
        //.....

        int[] test2 = {1, 2, 3};

        //arraylist
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(7);
        System.out.println(arrayList.toString());

        arrayList.remove(0);
        System.out.println(arrayList.toString());

        arrayList.add(11);
        arrayList.add(11);
        System.out.println(arrayList.toString());

        arrayList.add(2, 33);
        System.out.println(arrayList.toString());

        ArrayList<Integer> arrayList1 = new ArrayList<>();

        arrayList1.add(0);
        arrayList1.add(0);

        arrayList.addAll(arrayList1);

        System.out.println(arrayList.toString());

        arrayList.set(3, 5555);
        System.out.println(arrayList.toString());

        arrayList.clear();
        System.out.println(arrayList.toString());
    }
}
