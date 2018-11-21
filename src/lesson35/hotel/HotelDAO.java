package lesson35.hotel;

import lesson35.Content;
import lesson35.Validate;

import java.io.*;

/**
 * Created by Valik on 05.11.2018.
 */
public class HotelDAO {
    private byte valueWriteFile = 0;
    private byte valueReadFile = 0;
    private static File fileHotelDb = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\HotelDb.txt");

    public StringBuffer findHotelByName() throws Exception {
        valueReadFile = Validate.validateValueWriteReadFile(valueReadFile, fileHotelDb);

        return Content.readFile(fileHotelDb);
    }

    public StringBuffer findHotelByCity() throws Exception {
        valueReadFile = Validate.validateValueWriteReadFile(valueReadFile, fileHotelDb);

        return Content.readFile(fileHotelDb);
    }

    public StringBuffer findHotelById() throws Exception {
        valueReadFile = Validate.validateValueWriteReadFile(valueReadFile, fileHotelDb);

        return Content.readFile(fileHotelDb);
    }

    public void addHotel(){

    }
}
