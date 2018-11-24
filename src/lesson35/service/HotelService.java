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

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        HotelDAO hotelDAO = new HotelDAO();
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
        HotelDAO hotelDAO = new HotelDAO();
        Validate.validateUserLogIn();

        ArrayList<Hotel> hotels = new ArrayList<>();
        String hotelContent = hotelDAO.findHotelByCity().toString();
        for (Hotel hotel : findHotel(hotelContent)) {
            if (hotel.getCity().equals(city))
                hotels.add(hotel);
        }
        return hotels;
    }

    public Hotel findHotelById(Long id) throws Exception {
        HotelDAO hotelDAO = new HotelDAO();

        String hotelContent = hotelDAO.findHotelById().toString();
        for(Hotel hotel : findHotel(hotelContent)){
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
        checkNull(hotel);



    }

    private ArrayList<Hotel> findHotel(String hotelContent) {
        String[] hotels = hotelContent.split("\n");

        ArrayList<Hotel> hotels1 = new ArrayList<>();
        for (String hotel : hotels) {
            String[] valuesHotel = hotel.split(", ");
            hotels1.add(new Hotel(Long.parseLong(valuesHotel[0]), valuesHotel[1], valuesHotel[2], valuesHotel[3], valuesHotel[4]));
        }

        return hotels1;
    }

    private boolean checkNull(Hotel hotel) throws IllegalAccessException {
        for (Field f : getClass().getDeclaredFields())
            if (f.get(this) != null)
                throw new IllegalArgumentException("Hotel " + hotel.getId() + "can't have null");
        return true;
    }
}
