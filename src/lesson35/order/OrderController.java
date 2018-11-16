package lesson35.order;

import lesson35.room.Room;

/**
 * Created by Valik on 05.11.2018.
 */
public class OrderController {

    OrderService orderService = new OrderService();

    public void bookRoom(Order order) throws Exception {
        orderService.bookRoom(order);
    }

}
