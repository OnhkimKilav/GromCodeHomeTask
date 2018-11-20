package lesson35.order;

/**
 * Created by Valik on 05.11.2018.
 */
public class OrderController {

    private OrderService orderService = new OrderService();

    public void bookRoom(Order order) throws Exception {
        orderService.bookRoom(order);
    }

    public void cancelReservation(Long roomId, Long userId) throws Exception {
        orderService.cancelReservation(roomId, userId);
    }

}
