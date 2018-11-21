package lesson35.DAO;

import lesson35.util.Content;
import lesson35.util.Validate;
import lesson35.model.Room;

import java.io.*;
import java.util.Date;

/**
 * Created by Valik on 05.11.2018.
 */
public class RoomDAO {
    private File fileRoomDb = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\RoomDb.txt");
    private byte valueWriteFile = 0;
    private byte valueReadFile = 0;

    public void bookRoom(Room room, Date dateTo) throws Exception {
        valueWriteFile = Validate.validateValueWriteFile(valueWriteFile, fileRoomDb);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileRoomDb, true))) {
            writer.write(String.valueOf(room.getId()) + ", " + room.getNumberOfGuests() + ", " + room.getPrice() + ", " + room.getBreakfastIncluded() + ", " + room.getPetsAllowed() + ", " + Content.dateToStr(dateTo) + ", " + room.getHotel() + "\n");
        } catch (IOException e) {
            System.err.println("Room " + room.getId() + " can't write to file");
        }
    }

    public StringBuffer readFile() throws Exception {
        valueReadFile = Validate.validateValueReadFile(valueReadFile, fileRoomDb);

        return Content.readFile(fileRoomDb);
    }
}
