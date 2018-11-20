package lesson35.room;

import lesson35.Validate;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Valik on 05.11.2018.
 */
public class RoomDAO {
    private File fileRoomDb = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\RoomDb.txt");
    private byte valueWriteFile = 0;
    private byte valueReadFile = 0;

    public Room bookRoom(Room room, Date dateTo) throws Exception {
        if (valueWriteFile == 0) {
            Validate.validateFileWrite(fileRoomDb);
            valueWriteFile++;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileRoomDb, true))) {
            writer.write(String.valueOf(room.getId()) + ", " + room.getNumberOfGuests() + ", " + room.getPrice() + ", " + room.getBreakfastIncluded() + ", " + room.getPetsAllowed() + ", " + dateTo + ", " + room.getHotel() + "\n");
        } catch (IOException e) {
            System.err.println("Room " + room.getId() + " can't write to file");
        }

        return room;
    }

    public String[] readFile() throws Exception {
        if (valueReadFile == 0) {
            Validate.validateFileRead(fileRoomDb);
            valueReadFile++;
        }

        StringBuffer res = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileRoomDb))) {
            String line;
            while ((line = reader.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + fileRoomDb.toPath() + " failed");
        }

        String userContent = res.toString();
        String[] fileUsers = userContent.split("\n");

        return fileUsers;
    }

    public String dateToStr(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
    }
}
