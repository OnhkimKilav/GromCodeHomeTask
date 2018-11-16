package lesson35.order;

import lesson35.room.RoomDAO;

/**
 * Created by Valik on 05.11.2018.
 */
public class OrderService {

    OrderDAO orderDAO = new OrderDAO();

    public void bookRoom(Order order) throws Exception {
        orderDAO.bookRoom(order);
    }
}
