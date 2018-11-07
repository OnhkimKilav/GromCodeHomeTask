package lesson35.hotel;

import lesson35.exception.UserLogInException;
import lesson35.user.UserService;

/**
 * Created by Valik on 05.11.2018.
 */
public class HotelService {
    private HotelDAO hotelDAO = new HotelDAO();

    public StringBuffer findHotelByName(String name) throws Exception {
        if(name == null)
            throw new IllegalArgumentException("Name can't be null");
        if(UserService.userLogName == null)
            throw new UserLogInException("Login to use this feature");

        String userContent = hotelDAO.findHotelByName().toString();
        return findHotel(userContent, name, 1);
    }

    public StringBuffer findHotelByCity(String city) throws Exception {
        if(city == null)
            throw new IllegalArgumentException("City can't be null");
        if(UserService.userLogName == null)
            throw new UserLogInException("Login to use this feature");

        String userContent = hotelDAO.findHotelByCity().toString();
        return findHotel(userContent, city, 2);
    }

    private <T> StringBuffer findHotel(String userContent, T t, int place){
        String[] users = userContent.split("\n");

        StringBuffer res = new StringBuffer();
        for (String user : users) {
            String[] valuesUser = user.split(", ");
            if (valuesUser[place].equals(t)) {
                res.append(user).append("\n");
            }
        }
        return res;
    }
}
