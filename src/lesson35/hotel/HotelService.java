package lesson35.hotel;

import lesson35.Validate;
import lesson35.exception.UserLogInException;
import lesson35.user.UserService;

import java.util.ArrayList;

/**
 * Created by Valik on 05.11.2018.
 */
public class HotelService {
    private HotelDAO hotelDAO = new HotelDAO();

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        if (name == null)
            throw new IllegalArgumentException("Name can't be null");
        Validate.validateUserLogIn();

        ArrayList<Hotel> hotels = new ArrayList<>();
        String hotelContent = hotelDAO.findHotelByName().toString();
        for (Hotel hotel : findHotel(hotelContent)) {
            if (hotel.getName().equals(name))
                hotels.add(hotel);
        }
        return hotels;
    }

    /*public StringBuffer findHotelByCity(String city) throws Exception {
        if (city == null)
            throw new IllegalArgumentException("City can't be null");
        Validate.validateUserLogIn();

        String userContent = hotelDAO.findHotelByCity().toString();
        return findHotel(userContent, city, 2);
    }*/

    private ArrayList<Hotel> findHotel(String userContent) {
        String[] users = userContent.split("\n");

        ArrayList<Hotel> hotels = new ArrayList<>();
        for (String user : users) {
            String[] valuesUser = user.split(", ");
            hotels.add(new Hotel(valuesUser[0], valuesUser[1], valuesUser[2], valuesUser[3]));
        }

        return hotels;
    }
}
