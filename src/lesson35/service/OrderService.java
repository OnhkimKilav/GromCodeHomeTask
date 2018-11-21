package lesson35.service;

import lesson35.util.WorkWithContent;
import lesson35.DAO.OrderDAO;
import lesson35.model.Order;

/**
 * Created by Valik on 05.11.2018.
 */
public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();
    private UserService userService = new UserService();
    private RoomService roomService = new RoomService();

    public void cancelReservation(Long roomId, Long userId) throws Exception {
        String orderContent = orderDAO.readOrder().toString();
        String[] fileOrders = orderContent.split("\n");
        orderDAO.cleaningFile();

        for (String fileOrder : fileOrders) {
            String[] valuesOrder = fileOrder.split(", ");
            Order order = new Order(Long.valueOf(valuesOrder[0]), userService.findUserById(Long.valueOf(valuesOrder[1])), roomService.findRoomById(Long.valueOf(valuesOrder[2])), WorkWithContent.strToDate(valuesOrder[3]), WorkWithContent.strToDate(valuesOrder[4]), Double.valueOf(valuesOrder[5]));
            if (!(order.getRoom().getId() == roomId) && !(order.getUser().getId() == userId))
                orderDAO.writeOrder(order);
        }
    }
}
