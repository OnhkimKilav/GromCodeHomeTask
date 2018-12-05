package lesson35.DAO;

import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;
import lesson35.util.Validate;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Valik on 05.11.2018.
 */
public class HotelDAO extends GeneralDAO {
    private static File fileHotelDb = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\HotelDb.txt");

    static {
        try {
            Validate.validateFileRead(fileHotelDb);
            Validate.validateFileWrite(fileHotelDb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Hotel transformationStringToUser(String[] valuesHotel) {
        return new Hotel(Long.parseLong(valuesHotel[0]), valuesHotel[1], valuesHotel[2], valuesHotel[3], valuesHotel[4]);
    }

    public ArrayList<Hotel> listHotel() throws Exception {
        ArrayList<Hotel> res = new ArrayList<>();
        String hotelContent = GeneralDAO.readFile(fileHotelDb).toString();
        String[] fileHotels = hotelContent.split("\n");

        for (String hotel : fileHotels) {
            String[] valuesHotel = hotel.split(", ");
            res.add(transformationStringToUser(valuesHotel));
        }

        return res;
    }
}
