package lesson35.service;

import lesson35.DAO.RoomDAO;
import lesson35.exception.RoomNotFindException;
import lesson35.model.Order;
import lesson35.DAO.OrderDAO;
import lesson35.model.Room;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Valik on 05.11.2018.
 */
public class RoomService {
    private RoomDAO roomDAO = new RoomDAO();
    private UserService userService = new UserService();
    private OrderDAO orderDAO = new OrderDAO();
    private OrderService orderService = new OrderService();

    public RoomService() throws Exception {
    }

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        for (Room room : roomDAO.listRoom()) {
            if(room.getId() == roomId && room.getHotel().getId() == hotelId && (new Date().getTime() - Long.parseLong(String.valueOf(room.getDateAvailableFrom())) >= 0)) {
                Order order = new Order(userService.findUserById(userId), room, new Date(), dateTo(), room.getPrice());
                orderDAO.writeOrder(order);
                roomDAO.bookRoom(room, dateTo());
                continue;
            }
            roomDAO.bookRoom(room, room.getDateAvailableFrom());
        }
        throw new RoomNotFindException("Room " + roomId + " currently not available");
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        for (Room room : roomDAO.listRoom()) {
            if(room.getId() == roomId) {
                orderService.cancelReservation(roomId, userId);
                roomDAO.bookRoom(room, new Date());
                break;
            }
        }
    }

    public Room findRoomById(Long id) throws Exception {
        for(Room room : roomDAO.listRoom()){
            if(room.getId() == id)
                return room;
        }
        throw new RoomNotFindException("Room " + id + " don't found");
    }

    private Date dateTo(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 3); //minus number would decrement the days
        return cal.getTime();
    }

}
