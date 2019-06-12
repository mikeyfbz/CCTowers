import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class HotelTest {

    Hotel hotel;
    Room bedroom;
    Room doubleBedroom;
    Room conferenceRoom;
    Guest guest;
    Guest guest2;
    Booking booking;


    @Before
    public void before(){
        bedroom = new Room("101", "single", 1, 30);
        doubleBedroom = new Room("105", "double", 2, 60);
        conferenceRoom = new Room("MarbleChamber", "conference", 10, 100);
        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(bedroom);
        rooms.add(conferenceRoom);
        rooms.add(doubleBedroom);
        hotel = new Hotel("Faulty Towers", rooms);
        guest = new Guest("Ken");
        guest2 = new Guest("Tom");
        booking = new Booking(bedroom, 3, 30, guest);
    }

    @Test
    public void hotelHasAName(){
        assertEquals("Faulty Towers", hotel.getName());
    }

    @Test
    public void hotelHasRooms(){
        assertEquals(3, hotel.roomCount());
    }

    @Test
    public void aHotelCanCheckInAGuest(){
        hotel.bookRoom(bedroom, guest, 4);
        hotel.checkInGuest(guest, bedroom);
        assertEquals(1, hotel.checkRoomOccupancy(bedroom));
    }

    @Test
    public void aHotelCanCheckOutGuest(){
        hotel.checkInGuest(guest, bedroom);
        hotel.checkOutGuest(guest, bedroom);
        assertEquals(0, hotel.checkRoomOccupancy(bedroom));
    }

    @Test
    public void aHotelCanBookARoom(){
        hotel.bookRoom(bedroom, guest, 5);
        assertEquals(1, hotel.countNumberOfBookings());
    }

    @Test
    public void aHotelCanBookTwoPeopleIntoARoom(){
        hotel.bookRoom(bedroom, guest, 5);
        hotel.bookRoom(bedroom, guest2, 3);
        assertEquals(2, hotel.countNumberOfBookings());
    }

    @Test
    public void aHotelCanCheckHowManyVacantRoomsThereAre(){
        hotel.createVacantRoomList();
        assertEquals(3, hotel.checkVacantRooms());
    }

    @Test
    public void aHotelCanOnlyBookVacantRooms(){
        hotel.bookRoom(bedroom, guest, 3);
        hotel.checkInGuest(guest, bedroom);
        hotel.bookRoom(bedroom, guest2, 3);
        hotel.checkInGuest(guest2,bedroom);
        assertEquals(1, bedroom.countGuests());
    }

    @Test
    public void aHotelCanCheckIfARoomIsVacant(){
        assertEquals(true, hotel.checkRoomIsVacant(bedroom));
    }

}
