package lesson35.room;

import lesson35.exception.RoomNotFindException;
import lesson35.exception.UserNotRegisterException;
import lesson35.hotel.HotelController;
import lesson35.order.Order;
import lesson35.order.OrderController;
import lesson35.order.OrderService;
import lesson35.user.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Valik on 05.11.2018.
 */
public class RoomService {
    private RoomDAO roomDAO = new RoomDAO();

    public Room bookRoom(long roomId, long userId, long hotelId) throws Exception {
        //проверить комнату на бронь
        //забронировать комнату
        //записать новые данные
        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        HotelController hotelController = new HotelController();
        StringBuffer res = new StringBuffer();
        System.out.println(res);

        for (String fileRoom : roomDAO.readFile()) {
            String[] valuesRoom = fileRoom.split(", ");
            Room room = new Room(Long.valueOf(valuesRoom[0]), Integer.valueOf(valuesRoom[1]), Double.valueOf(valuesRoom[2]), Boolean.valueOf(valuesRoom[3]), Boolean.valueOf(valuesRoom[4]), strToDate(valuesRoom[5]), hotelController.findHotelById(Long.valueOf(valuesRoom[6])));
            if(room.getId() == roomId && room.getHotel().getId() == hotelId && (new Date().getTime() - Long.parseLong(String.valueOf(room.getDateAvailableFrom())) >= 0)) {
                Order order = new Order(userService.findUserById(userId), room, new Date(), dateTo(), room.getPrice());
                orderService.bookRoom(order);
                return roomDAO.bookRoom(room, dateTo());
            }
        }
        throw new RoomNotFindException("Room " + roomId + " currently not available");
    }

    private Date dateTo(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 3); //minus number would decrement the days
        return cal.getTime();
    }

    public Date strToDate(String s) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd-MM-yyyy");
        Date docDate= format.parse(s);
        return docDate;
    }

}
