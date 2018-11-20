package lesson35.order;

import lesson35.room.RoomService;
import lesson35.user.UserService;

/**
 * Created by Valik on 05.11.2018.
 */
public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();
    private UserService userService = new UserService();
    private RoomService roomService = new RoomService();

    public void bookRoom(Order order) throws Exception {
        orderDAO.writeOrder(order);
    }

    public void cancelReservation(Long roomId, Long userId) throws Exception {
        String userContent = orderDAO.readOrder().toString();
        String[] fileUsers = userContent.split("\n");
        orderDAO.cleaningFile();

        for (String fileRoom : fileUsers) {
            String[] valuesRoom = fileRoom.split(", ");
            Order order = new Order(Long.valueOf(valuesRoom[0]), userService.findUserById(Long.valueOf(valuesRoom[1])), roomService.findRoomById(Long.valueOf(valuesRoom[2])), roomService.strToDate(valuesRoom[3]), roomService.strToDate(valuesRoom[4]), Double.valueOf(valuesRoom[5]));
            if (!(order.getRoom().getId() == roomId) && !(order.getUser().getId() == userId))
                orderDAO.writeOrder(order);
        }
    }
}
