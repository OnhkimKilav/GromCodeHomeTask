package lesson35.DAO;

import lesson35.model.Hotel;
import lesson35.util.WorkWithContent;
import lesson35.util.Validate;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Valik on 05.11.2018.
 */
public class HotelDAO {
    private static File fileHotelDb = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\HotelDb.txt");

    public void addHotel(){

    }

    public ArrayList<Hotel> listHotel() throws Exception {
        ArrayList<Hotel> res = new ArrayList<>();
        String hotelContent = WorkWithContent.readFile(fileHotelDb).toString();
        String[] fileHotels = hotelContent.split("\n");

        for (String hotel : fileHotels) {
            String[] valuesHotel = hotel.split(", ");
            res.add(new Hotel(Long.parseLong(valuesHotel[0]), valuesHotel[1], valuesHotel[2], valuesHotel[3], valuesHotel[4]));
        }

        return res;
    }

    static {
        try {
            Validate.validateFileRead(fileHotelDb);
            Validate.validateFileWrite(fileHotelDb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
