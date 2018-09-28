package lesson27.hometask;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Valik on 26.09.2018.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        Order order = new Order(555, 345, "fds", "fgsdf", "trewdr");
        System.out.println(useList(order));
    }
    public static LinkedList<Order> useList(Order order) {

        LinkedList<Order> orderLinkedList = new LinkedList<>();

        if(!orderLinkedList.isEmpty())
            orderLinkedList.clear();

        orderLinkedList.add(order);
        orderLinkedList.add(order);

        int index = 0;
        for(Order order1 : orderLinkedList)
            index++;

        if (index >= 2);
        orderLinkedList.add(0, new Order(2334, 6777, "fdsdf", "rtetr", "jjjj"));

        if (index >= 3)
            orderLinkedList.set(1, new Order(123, 999, "usd", "sdas", "dfgdfg"));

        orderLinkedList.add(new Order(0, 0, null, null, null));

        Order order1 = new Order(0, 0, null, null, null);
        if (orderLinkedList.subList(0, orderLinkedList.size()).contains(order1))
            orderLinkedList.remove(order1);

        LinkedList<Order> orderLinkedList1 = new LinkedList<>();
        orderLinkedList1.add(new Order(854, 5000, "ua", "fdsfds", "gdsadrwerr"));
        orderLinkedList1.add(new Order(853, 5060, "ua", "fdsfds", "gdsadrwerr"));
        orderLinkedList.addAll(orderLinkedList1);

        if(!orderLinkedList.isEmpty())
            orderLinkedList.remove(0);

        Order[] orders = new Order[orderLinkedList.size()];
        orderLinkedList.toArray(orders);

        return orderLinkedList;
    }
}
