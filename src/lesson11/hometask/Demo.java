package lesson11.hometask;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Valik on 18.04.2018.
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("BookingComAPI");
        //test BookingComAPI method findRooms
        //найти комнату по заданным параметрам +
        //найти комнату по отрицательной цене +
        //найти комнату по Null переменным +

        Room room = new Room(7945, 100, 1, new Date(), "Vicktoria", "Donetsk");
        Room room1 = new Room(645, 100, 1, new Date(), "Vicktoria", "Donetsk");
        Room room2 = new Room(7045, 500, 3, new Date(), "Vicktoria", "Donetsk");
        Room[] rooms = new Room[]{room, room1, room2};

        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        for (Room room3 : bookingComAPI.findRooms(150, 1, "Donetsk", "Vicktoria")) {
            System.out.println(room3.getId());
        }

        for (Room room3 : bookingComAPI.findRooms(-150, 1, "Donetsk", "Vicktoria")) {
            System.out.println(room3.getId());
        }

        for (Room room3 : bookingComAPI.findRooms(150, 1, null, null)) {
            System.out.println(room3.getId());
        }

        System.out.println("Controller");
        //test Controller method check
        //найти общие комнаты у двух API +
        //найти общие комнаты при разных переменных +

        Room roomController = new Room(7945, 100, 1, new Date(), "Vicktoria", "Donetsk");
        Room roomController1 = new Room(7947, 200, 1, new Date(), "Vicktoria", "Donetsk");
        Room roomController2 = new Room(7946, 500, 3, new Date(), "Vicktoria", "Donetsk");
        Room[] roomsController = new Room[]{roomController, roomController1, roomController2};
        BookingComAPI bookingComAPI1 = new BookingComAPI(roomsController);

        Room roomController3 = new Room(7945, 100, 1, new Date(), "Vicktoria", "Donetsk");
        Room roomController4 = new Room(79451, 300, 2, new Date(), "Vicktoria", "Donetsk");
        Room roomController5 = new Room(7946, 500, 3, new Date(), "Vicktoria", "Donetsk");
        Room[] roomsController2 = new Room[]{roomController3, roomController4, roomController5};
        BookingComAPI bookingComAPI2 = new BookingComAPI(roomsController2);
        BookingComAPI[] bookingComAPIS = new BookingComAPI[]{bookingComAPI1, bookingComAPI2};

        Controller controller = new Controller(bookingComAPIS, bookingComAPIS);

        for(Room roomController6 : controller.check(bookingComAPI1,bookingComAPI2)){
            System.out.println(roomController6.getId());
        }

        System.out.println();
        Room roomController6 = new Room(7945, 100, 1, new Date(), "Vicktoria", "Donetsk");
        Room roomController7 = new Room(7947, 200, 1, new Date(), "Vicktoria", "Donetsk");
        Room roomController8 = new Room(7946, 500, 3, new Date(), "Vicktoria", "Donetsk");
        Room[] roomsController3 = new Room[]{roomController6, roomController7, roomController8};
        BookingComAPI bookingComAPI3 = new BookingComAPI(roomsController3);

        Room roomController9 = new Room(7945, 150, 1, new Date(), "Vicktoria", "Donetsk");
        Room roomController10 = new Room(79451, 300, 2, new Date(), "Vicktoria", "Donetsk");
        Room roomController11 = new Room(7946, 600, 4, new Date(), "Vicktoria", "Donetsk");
        Room[] roomsController4 = new Room[]{roomController9, roomController10, roomController11};
        BookingComAPI bookingComAPI4 = new BookingComAPI(roomsController4);
        BookingComAPI[] bookingComAPIS2 = new BookingComAPI[]{bookingComAPI3, bookingComAPI4};

        Controller controller1 = new Controller(bookingComAPIS2, bookingComAPIS2);

        for(Room roomController12 : controller1.check(bookingComAPI3,bookingComAPI4)){
            System.out.println(roomController12.getId());
        }


        System.out.println("GoogleAPI");
        //Test GoogleAPI method findRooms
        //найти комнату по заданным параметрам +
        //найти комнату по отрицательной цене +
        //найти комнату по Null переменным +

        GoogleAPI googleAPI = new GoogleAPI(rooms);
        for (Room roomGoogle : googleAPI.findRooms(150, 1, "Donetsk", "Vicktoria")) {
            System.out.println(roomGoogle.getId());
        }

        for (Room roomGoogle : googleAPI.findRooms(-150, 1, "Donetsk", "Vicktoria")) {
            System.out.println(roomGoogle.getId());
        }

        for (Room roomGoogle : googleAPI.findRooms(150, 1, null, null)) {
            System.out.println(roomGoogle.getId());
        }

        System.out.println("TripAdvisor");
        //test TripAdvisor method FindRooms
        //найти комнаты по заданным параметрам +
        //найти комнату по отрицательным местам  +
        //найти комнату по Null переменным +

        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
        for (Room roomTripAdvisorAPI : tripAdvisorAPI.findRooms(100, 1, "Donetsk", "Vicktoria")) {
            System.out.println(roomTripAdvisorAPI.getId());
        }

        for (Room roomTripAdvisorAPI : tripAdvisorAPI.findRooms(100, -1, "Donetsk", "Vicktoria")) {
            System.out.println(roomTripAdvisorAPI.getId());
        }

        for (Room roomTripAdvisorAPI : tripAdvisorAPI.findRooms(100, 1, null, null)) {
            System.out.println(roomTripAdvisorAPI.getId());
        }
    }
}
