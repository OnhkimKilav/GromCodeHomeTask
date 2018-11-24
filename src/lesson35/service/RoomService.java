package lesson35.service;

import lesson35.util.WorkWithContent;
import lesson35.DAO.RoomDAO;
import lesson35.exception.RoomNotFindException;
import lesson35.controller.HotelController;
import lesson35.model.Order;
import lesson35.DAO.OrderDAO;
import lesson35.model.Room;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Valik on 05.11.2018.
 */
public class RoomService {
    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        RoomDAO roomDAO = new RoomDAO();
        UserService userService = new UserService();
        OrderDAO orderDAO = new OrderDAO();

        for (Room room : findRoom(roomDAO.readFile().toString())) {
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
        RoomDAO roomDAO = new RoomDAO();
        OrderService orderService = new OrderService();

        for (Room room : findRoom(roomDAO.readFile().toString())) {
            if(room.getId() == roomId) {
                orderService.cancelReservation(roomId, userId);
                roomDAO.bookRoom(room, new Date());
                continue;
            }
            roomDAO.bookRoom(room, room.getDateAvailableFrom());
        }
    }

    public Room findRoomById(Long id) throws Exception {
        RoomDAO roomDAO = new RoomDAO();

        for(Room room : findRoom(roomDAO.readFile().toString())){
            if(room.getId() == id)
                return room;
        }
        throw new NoSuchFieldError("Room " + id + " don't found");
    }

    private ArrayList<Room> findRoom(String roomContent) throws Exception {
        HotelService hotelService = new HotelService();

        String[] rooms = roomContent.split("\n");

        ArrayList<Room> rooms1 = new ArrayList<>();
        for (String room : rooms) {
            String[] valuesRoom = room.split(", ");
            rooms1.add(new Room(Long.valueOf(valuesRoom[0]), Integer.valueOf(valuesRoom[1]), Double.valueOf(valuesRoom[2]), Boolean.valueOf(valuesRoom[3]), Boolean.valueOf(valuesRoom[4]), WorkWithContent.strToDate(valuesRoom[5]), hotelService.findHotelById(Long.valueOf(valuesRoom[6]))));
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
