package lesson27;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Valik on 28.09.2018.
 */
public class TestPerformance {
    public static void main(String[] args) {
        testAddMethod();
        testRemoveMethod();
        testGetMethod();

    }

    private static void testAddMethod(){
        ArrayList<String> stringArrayList = new ArrayList<>();

        Date start = new Date();

        for(int i = 0; i < 1_000_00; i++){
            stringArrayList.add(0, String.valueOf(i));
        }

        Date finish = new Date();

        System.out.println("add - array list: " + (finish.getTime() - start.getTime()));

        //linked list

        LinkedList<String> stringLinkedList = new LinkedList<>();

        Date start1 = new Date();

        for(int i = 0; i < 1_000_00; i++){
            stringLinkedList.add(0, String.valueOf(i));
        }

        Date finish1 = new Date();

        System.out.println("add - linked list: " + (finish1.getTime() - start1.getTime()));
    }

    private static void testRemoveMethod(){
        ArrayList<String> stringArrayList = new ArrayList<>();

        for(int i = 0; i < 1_000_00; i++){
            stringArrayList.add(i, String.valueOf(i));
        }

        Date start = new Date();

        for(int i = 0; i < 97000; i++){
            stringArrayList.remove(3000);
        }

        Date finish = new Date();

        System.out.println("remove - array list: " + (finish.getTime() - start.getTime()));

        //linked list

        LinkedList<String> stringLinkedList = new LinkedList<>();

        for(int i = 0; i < 1_000_00; i++){
            stringLinkedList.add(i, String.valueOf(i));
        }
        Date start1 = new Date();

        for(int i = 0; i < 97000; i++){
            stringLinkedList.remove(3000);
        }

        Date finish1 = new Date();

        System.out.println("remove - linked list: " + (finish1.getTime() - start1.getTime()));
    }

    private static void testGetMethod(){
        ArrayList<String> stringArrayList = new ArrayList<>();

        for(int i = 0; i < 1_000_00; i++){
            stringArrayList.add(i, String.valueOf(i));
        }

        Date start = new Date();

        for(int i = 0; i < 100000; i++){
            stringArrayList.get(50000);
        }

        Date finish = new Date();

        System.out.println("get - array list: " + (finish.getTime() - start.getTime()));

        //linked list

        LinkedList<String> stringLinkedList = new LinkedList<>();

        for(int i = 0; i < 1_000_00; i++){
            stringLinkedList.add(i, String.valueOf(i));
        }
        Date start1 = new Date();

        for(int i = 0; i < 100000; i++){
            stringLinkedList.get(50000);
        }

        Date finish1 = new Date();

        System.out.println("get - linked list: " + (finish1.getTime() - start1.getTime()));
    }
}
