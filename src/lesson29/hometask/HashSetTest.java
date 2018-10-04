package lesson29.hometask;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Valik on 03.10.2018.
 */
public class HashSetTest {
    public static void main(String[] args) {
        iterator(useHashSet());
    }

    public static HashSet<Order> useHashSet(){
        HashSet<Order> hashSet = new HashSet<>();
        Order order1 = new Order(123, 444, "usd", "tv", "Amazon");
        Order order2 = new Order(5466, 5, "ua", "pen", "School_Shop");
        Order order3 = new Order(12223, 47, "ru", "beer", "7");

        hashSet.add(order1);
        hashSet.add(order2);
        hashSet.add(order3);

        hashSet.remove(order2);

        hashSet.add(order2);

        HashSet<Order> hashSet1 = new HashSet<>();
        Order order4 = new Order(1111, 6,"usd", "tv", "Amazon");
        Order order5 = new Order(5466, 5, "ua", "pen", "School_Shop");
        Order order6 = new Order(12223, 47, "ru", "beer", "7");

        hashSet1.add(order4);
        hashSet1.add(order5);
        hashSet1.add(order6);

        hashSet.retainAll(hashSet1);

        Order[] orderArray = new Order[hashSet.size()];
        hashSet.toArray(orderArray);

        hashSet.add(order1);
        hashSet.add(order4);
        Order order7 = new Order(345457, 57, "uaf", "beef", "minimarket");
        hashSet.add(order7);


        return hashSet;
    }

    private static void iterator(HashSet<Order> orders){
        Iterator<Order> iterator = orders.iterator();

        while(iterator.hasNext())
            System.out.println(iterator.next());
    }

}
