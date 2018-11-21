package lesson35.demo;

import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.DAO.RoomDAO;
import lesson35.service.RoomService;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Valik on 05.11.2018.
 */
public class DemoRoom {
    public static void main(String[] args) throws ParseException {
        RoomDAO roomDAO = new RoomDAO();
        RoomService roomService = new RoomService();
        Room room = new Room(2, 1500, true, false, new Date(), new Hotel("Ug", "Ukraine", "Kiev", "test"));
        //System.out.println(room.getDateAvailableFrom());

    }
}
