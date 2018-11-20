package lesson35.demo;

import lesson35.order.OrderController;

/**
 * Created by Valik on 05.11.2018.
 */
public class DemoOrder {
    public static void main(String[] args) throws Exception {
        OrderController orderController = new OrderController();
        orderController.cancelReservation(3673L, 244L);
    }
}
