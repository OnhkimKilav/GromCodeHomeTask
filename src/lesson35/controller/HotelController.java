package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.service.HotelService;

import java.util.ArrayList;

/**
 * Created by Valik on 05.11.2018.
 */
public class HotelController {
    private HotelService hotelService = new HotelService();

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        return hotelService.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        return hotelService.findHotelByCity(city);
    }

    public void addHotel(Hotel hotel) throws Exception {
        hotelService.addHotel(hotel);
    }
}
