package lesson35.DAO;

import lesson35.model.User;
import lesson35.service.HotelService;
import lesson35.util.Validate;
import lesson35.model.Room;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Valik on 05.11.2018.
 */
public class RoomDAO extends GeneralDAO{
    private static File fileRoomDb = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\RoomDb.txt");

    @Override
    public Room transformationStringToUser(String[] valuesRoom) throws Exception {
        HotelService hotelService = new HotelService();
        return new Room(Long.valueOf(valuesRoom[0]), Integer.valueOf(valuesRoom[1]), Double.valueOf(valuesRoom[2]), Boolean.valueOf(valuesRoom[3]), Boolean.valueOf(valuesRoom[4]), GeneralDAO.strToDate(valuesRoom[5]), hotelService.findHotelById(Long.valueOf(valuesRoom[6])));
    }

    static {
        try {
            Validate.validateFileRead(fileRoomDb);
            Validate.validateFileWrite(fileRoomDb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bookRoom(Room room, Date dateTo) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileRoomDb, true))) {
            writer.write(String.valueOf(room.getId()) + ", " + room.getNumberOfGuests() + ", " + room.getPrice() + ", " + room.getBreakfastIncluded() + ", " + room.getPetsAllowed() + ", " + GeneralDAO.dateToStr(dateTo) + ", " + room.getHotel() + "\n");
        } catch (IOException e) {
            throw new IOException("Room " + room.getId() + " can't write to file");
        }
    }

    public ArrayList<Room> listRoom() throws Exception {
        ArrayList<Room> res = new ArrayList<>();
        String roomContent = GeneralDAO.readFile(fileRoomDb).toString();
        String[] fileRooms = roomContent.split("\n");

        for (String room : fileRooms) {
            String[] valuesRoom = room.split(", ");
            res.add(transformationStringToUser(valuesRoom));
        }

        return res;
    }
}
