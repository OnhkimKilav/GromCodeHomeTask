package lesson35.room;

import lesson35.Content;
import lesson35.exception.RoomNotFindException;
import lesson35.hotel.HotelController;
import lesson35.order.Order;
import lesson35.order.OrderController;
import lesson35.user.UserService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Valik on 05.11.2018.
 */
public class RoomService {
    private RoomDAO roomDAO = new RoomDAO();
    private OrderController orderController = new OrderController();
    private UserService userService = new UserService();
    private HotelController hotelController = new HotelController();

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        //проверить комнату на бронь
        //забронировать комнату
        //записать новые данные

        for (Room room : findRoom(roomDAO.readFile().toString())) {
            if(room.getId() == roomId && room.getHotel().getId() == hotelId && (new Date().getTime() - Long.parseLong(String.valueOf(room.getDateAvailableFrom())) >= 0)) {
                Order order = new Order(userService.findUserById(userId), room, new Date(), dateTo(), room.getPrice());
                orderController.bookRoom(order);
                roomDAO.bookRoom(room, dateTo());
                continue;
            }
            roomDAO.bookRoom(room, room.getDateAvailableFrom());
        }
        throw new RoomNotFindException("Room " + roomId + " currently not available");
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        for (Room room : findRoom(roomDAO.readFile().toString())) {
            if(room.getId() == roomId) {
                orderController.cancelReservation(roomId, userId);
                roomDAO.bookRoom(room, new Date());
                continue;
            }
            roomDAO.bookRoom(room, room.getDateAvailableFrom());
        }
    }

    public Room findRoomById(Long id) throws Exception {
        for(Room room : findRoom(roomDAO.readFile().toString())){
            if(room.getId() == id)
                return room;
        }
        throw new NoSuchFieldError("Room " + id + " don't found");
    }

    private ArrayList<Room> findRoom(String roomContent) throws Exception {
        String[] rooms = roomContent.split("\n");

        ArrayList<Room> rooms1 = new ArrayList<>();
        for (String room : rooms) {
            String[] valuesRoom = room.split(", ");
            rooms1.add(new Room(Long.valueOf(valuesRoom[0]), Integer.valueOf(valuesRoom[1]), Double.valueOf(valuesRoom[2]), Boolean.valueOf(valuesRoom[3]), Boolean.valueOf(valuesRoom[4]), Content.strToDate(valuesRoom[5]), hotelController.findHotelById(Long.valueOf(valuesRoom[6]))));
        }

        return rooms1;
    }

    private Date dateTo(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 3); //minus number would decrement the days
        return cal.getTime();
    }

}
