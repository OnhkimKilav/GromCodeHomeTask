package lesson35.DAO;

import lesson35.util.WorkWithContent;
import lesson35.util.Validate;

import java.io.*;

/**
 * Created by Valik on 05.11.2018.
 */
public class HotelDAO {
    private byte valueWriteFile = 0;
    private byte valueReadFile = 0;
    private static File fileHotelDb = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\HotelDb.txt");

    public StringBuffer findHotelByName() throws Exception {
        valueReadFile = Validate.validateValueReadFile(valueReadFile, fileHotelDb);

        return WorkWithContent.readFile(fileHotelDb);
    }

    public StringBuffer findHotelByCity() throws Exception {
        valueReadFile = Validate.validateValueReadFile(valueReadFile, fileHotelDb);

        return WorkWithContent.readFile(fileHotelDb);
    }

    public StringBuffer findHotelById() throws Exception {
        valueReadFile = Validate.validateValueReadFile(valueReadFile, fileHotelDb);

        return WorkWithContent.readFile(fileHotelDb);
    }

    public void addHotel(){

    }
}
