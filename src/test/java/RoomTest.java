import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RoomTest {

    Room room;
    Guest guest;
    Room conferenceRoom;

    @Before
    public void before(){
        room = new Room("101", "single", 1, 30);
        guest = new Guest("Rory");
        conferenceRoom = new Room("MarbleChamber", "conference", 10, 100);
    }

    @Test
    public void getRoomNumber(){
        assertEquals("101", room.getRoomName());
    }

    @Test
    public void getRoomType(){
        assertEquals("single", room.getRoomType());
    }

    @Test
    public void getRoomCapacity(){
        assertEquals(1, room.getCapacity());
    }

    @Test
    public void roomStartsEmpty(){
        assertEquals(0, room.countGuests());
    }

    @Test
    public void roomsCanAddGuests(){
        room.addGuest(guest);
        assertEquals(1, room.countGuests());
    }

    @Test
    public void roomsCannotExceedCapacity(){
        room.addGuest(guest);
        room.addGuest(guest);
        assertEquals(1, room.countGuests());
    }

    @Test
    public void conferenceRoomsCannotExceedCapacity(){
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest);
        assertEquals(10, conferenceRoom.countGuests());
    }

    @Test
    public void roomsCanEvacuateGuests(){
        room.addGuest(guest);
        room.removeGuest(guest);
        assertEquals(0, room.countGuests());
    }

    @Test
    public void roomsHaveARoomRate(){
        assertEquals(30, room.getRoomRate());
    }
}
