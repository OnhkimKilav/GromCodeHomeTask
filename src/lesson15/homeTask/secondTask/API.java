package lesson15.homeTask.secondTask;

/**
 * Created by Valik on 18.03.2018.
 */
public interface API {
    Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] getAll();
}
