package lesson11.hometask;

/**
 * Created by Valik on 18.03.2018.
 */
public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (Room room : rooms) {
            if (room.getPrice() == price && room.getCityName() == city && room.getHotelName() == hotel && room.getPersons() >= persons - 1 && room.getPersons() <= persons + 1) {
                count++;
            }
        }
        Room[] newRooms = new Room[count];
        int index = 0;
        for (Room room : rooms) {
            if (room.getPrice() == price && room.getCityName() == city && room.getHotelName() == hotel && room.getPersons() >= persons - 1 && room.getPersons() <= persons + 1) {
                newRooms[index] = room;
                index++;
            }
        }
        return newRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
