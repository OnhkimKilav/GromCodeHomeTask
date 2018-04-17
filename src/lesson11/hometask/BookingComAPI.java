package lesson11.hometask;

/**
 * Created by Valik on 18.03.2018.
 */
public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (Room room : rooms) {
            if (room.getPrice() >= price - 100 && room.getPrice() <= price + 100 && room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel) {
                count++;
            }
        }
        Room[] newRooms = new Room[count];
        int index = 0;
        for (Room room : rooms) {
            if (room.getPrice() >= price - 100 && room.getPrice() <= price + 100 && room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel) {
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
