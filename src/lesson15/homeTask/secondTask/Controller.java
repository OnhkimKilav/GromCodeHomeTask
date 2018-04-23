package lesson15.homeTask.secondTask;

import java.util.Arrays;

/**
 * Created by Valik on 19.03.2018.
 */
public class Controller {
    private API[] apis;
    private Room[] rooms;
    private BookingComAPI bookingComAPI = new BookingComAPI(rooms);
    private GoogleAPI googleAPI = new GoogleAPI(rooms);
    private TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
    private int index = 0;


    public Controller(API[] apis1, API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        for (Room room : bookingComAPI.findRooms(price, persons, city, hotel)) {
            rooms[index] = room;
            index++;
        }
        for (Room room : googleAPI.findRooms(price, persons, city, hotel)) {
            rooms[index] = room;
            index++;
        }
        for (Room room : tripAdvisorAPI.findRooms(price, persons, city, hotel)) {
            rooms[index] = room;
            index++;
        }
        return rooms;
    }


    public Room[] check(API api1, API api2) {
        int count = 0;
        for(Room room : api1.getAll()){
            for(Room room1 : api2.getAll()){
                if(room.getHotelName() == room1.getHotelName() && room.getPrice() == room1.getPrice() && room.getPersons() == room1.getPersons() && room.getCityName() ==room1.getCityName()){
                    count++;
                }
            }
        }
        Room[] newRooms = new Room[count];
        index = 0;
        for(Room room : api1.getAll()){
            for(Room room1 : api2.getAll()){
                if(room.getHotelName() == room1.getHotelName() && room.getPrice() == room1.getPrice() && room.getPersons() == room1.getPersons() && room.getCityName() ==room1.getCityName()){
                    newRooms[index] = room;
                    index++;
                }
            }
        }
        return newRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Controller that = (Controller) o;

        if (index != that.index) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(apis, that.apis)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(rooms, that.rooms)) return false;
        if (!bookingComAPI.equals(that.bookingComAPI)) return false;
        if (!googleAPI.equals(that.googleAPI)) return false;
        return tripAdvisorAPI.equals(that.tripAdvisorAPI);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(apis);
        result = 31 * result + Arrays.hashCode(rooms);
        result = 31 * result + bookingComAPI.hashCode();
        result = 31 * result + googleAPI.hashCode();
        result = 31 * result + tripAdvisorAPI.hashCode();
        result = 31 * result + index;
        return result;
    }
}
