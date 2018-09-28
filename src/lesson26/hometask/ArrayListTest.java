package lesson26.hometask;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Valik on 26.09.2018.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        Order order = new Order(555, 345, "fds", "fgsdf", "trewdr");
        System.out.println(useList(order));
    }
    public static ArrayList<Order> useList(Order order) {

        ArrayList<Order> orderArrayList = new ArrayList<>();

        if(!orderArrayList.isEmpty())
            orderArrayList.clear();

        orderArrayList.add(order);
        orderArrayList.add(order);

        int index = 0;
        for(Order order1 : orderArrayList)
            index++;

        if (index >= 2);
            orderArrayList.add(0, new Order(2334, 6777, "fdsdf", "rtetr", "jjjj"));

        if (index >= 3)
            orderArrayList.set(1, new Order(123, 999, "usd", "sdas", "dfgdfg"));

        orderArrayList.add(new Order(0, 0, null, null, null));

        Order order1 = new Order(0, 0, null, null, null);
        if (orderArrayList.subList(0, orderArrayList.size()).contains(order1))
            orderArrayList.remove(order1);

        ArrayList<Order> orderArrayList1 = new ArrayList<>();
        orderArrayList1.add(new Order(854, 5000, "ua", "fdsfds", "gdsadrwerr"));
        orderArrayList1.add(new Order(853, 5060, "ua", "fdsfds", "gdsadrwerr"));
        orderArrayList.addAll(orderArrayList1);

        if(!orderArrayList.isEmpty())
            orderArrayList.remove(0);

        Order[] orders = new Order[orderArrayList.size()];
        orderArrayList.toArray(orders);

        return orderArrayList;
    }
}
