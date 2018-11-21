package lesson35.controller;

import lesson35.service.RoomService;

/**
 * Created by Valik on 05.11.2018.
 */
public class RoomController {
    private RoomService roomService = new RoomService();

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        roomService.bookRoom(roomId, userId, hotelId);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        roomService.cancelReservation(roomId, userId);
    }
}
