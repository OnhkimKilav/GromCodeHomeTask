package lesson15.homeTask.secondTask;

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


    public Controller(API[] apis) {
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
                if(room.equals(room1)){
                    count++;
                }
            }
        }
        Room[] newRooms = new Room[count];
        index = 0;
        for(Room room : api1.getAll()){
            for(Room room1 : api2.getAll()){
                if(room.equals(room1)){
                    newRooms[index] = room;
                    index++;
                }
            }
        }
        return newRooms;
    }

}
