package lesson35.hotel;

import lesson35.Validate;
import lesson35.exception.UserLogInException;
import lesson35.exception.UserNotAdminException;
import lesson35.user.User;
import lesson35.user.UserService;

import java.lang.reflect.Field;
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

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        if (city == null)
            throw new IllegalArgumentException("City can't be null");
        Validate.validateUserLogIn();

        ArrayList<Hotel> hotels = new ArrayList<>();
        String hotelContent = hotelDAO.findHotelByCity().toString();
        for (Hotel hotel : findHotel(hotelContent)) {
            if (hotel.getCity().equals(city))
                hotels.add(hotel);
        }
        return hotels;
    }

    public void addHotel(Hotel hotel) throws Exception {
        //проверка залогинен ли он +
        //проверка админ ли он +
        //проверка на входящие данные +
        //проверка на идентичность отеля
        //записать отель
        Validate.validateUserLogIn();
        Validate.validateUserType(UserService.logInUser);
        checkNull(hotel);



    }

    private ArrayList<Hotel> findHotel(String userContent) {
        String[] users = userContent.split("\n");

        ArrayList<Hotel> hotels = new ArrayList<>();
        for (String user : users) {
            String[] valuesUser = user.split(", ");
            hotels.add(new Hotel(Long.parseLong(valuesUser[0]), valuesUser[1], valuesUser[2], valuesUser[3], valuesUser[4]));
        }

        return hotels;
    }

    private boolean checkNull(Hotel hotel) throws IllegalAccessException {
        for (Field f : getClass().getDeclaredFields())
            if (f.get(this) != null)
                throw new IllegalArgumentException("Hotel " + hotel.getId() + "can't have null");
        return true;
    }
}
