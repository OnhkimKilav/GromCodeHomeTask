package lesson35.service;

import lesson35.DAO.HotelDAO;
import lesson35.util.Validate;
import lesson35.model.Hotel;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by Valik on 05.11.2018.
 */
public class HotelService {
    private HotelDAO hotelDAO = new HotelDAO();

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        Validate.validateUserLogIn();

        ArrayList<Hotel> hotels = new ArrayList<>();
        for (Hotel hotel : hotelDAO.listHotel()) {
            if (hotel.getName().equals(name))
                hotels.add(hotel);
        }
        return hotels;
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        Validate.validateUserLogIn();

        ArrayList<Hotel> hotels = new ArrayList<>();

        for (Hotel hotel : hotelDAO.listHotel()) {
            if (hotel.getCity().equals(city))
                hotels.add(hotel);
        }
        return hotels;
    }

    public Hotel findHotelById(Long id) throws Exception {

        for(Hotel hotel : hotelDAO.listHotel()){
            if(hotel.getId() == id)
                return hotel;
        }
        throw new NoSuchFieldError("Hotel " + id + " don't found");
    }

    public void addHotel(Hotel hotel) throws Exception {
        //проверка залогинен ли он +
        //проверка админ ли он +
        //проверка на входящие данные +
        //проверка на идентичность отеля
        //записать отель
        Validate.validateUserLogIn();
        Validate.validateUserType(UserService.logInUser);
    }
}
