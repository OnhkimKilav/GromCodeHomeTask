package lesson35.hotel;

import java.util.ArrayList;

/**
 * Created by Valik on 05.11.2018.
 */
public class HotelController {
    private HotelService hotelService = new HotelService();

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        return hotelService.findHotelByName(name);
    }

    /*public StringBuffer findHotelByCity(String city) throws Exception {
        return hotelService.findHotelByCity(city);
    }*/
}
