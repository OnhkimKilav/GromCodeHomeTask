package lesson35.room;

/**
 * Created by Valik on 05.11.2018.
 */
public class RoomController {
    private RoomService roomService = new RoomService();

    public Room bookRoom(long roomId, long userId, long hotelId) throws Exception {
        return roomService.bookRoom(roomId, userId, hotelId);
    }
}
