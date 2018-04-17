package lesson11.hometask;

/**
 * Created by Valik on 18.03.2018.
 */
public interface API {
    Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] getAll();
}
