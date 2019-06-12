import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class BookingTest {

    Booking booking;
    Room bedroom;
    Room conferenceRoom;
    Guest guest;
    Hotel hotel;

    @Before
    public void before(){
        bedroom = new Room("101", "single", 1, 30);
        conferenceRoom = new Room("MarbleChamber", "conference", 10, 100);
        guest = new Guest("Ken");
        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(bedroom);
        rooms.add(conferenceRoom);
        hotel = new Hotel("Faulty Towers", rooms);
        booking = new Booking(bedroom, 3, 30, guest);
    }

    @Test
    public void bookingHadsARoom(){
        assertEquals("101", booking.getRoomDetails());
    }

    @Test
    public void bookingHasNumberOfNights(){
        assertEquals(3, booking.getNumberOfNights());
    }

    @Test
    public void bookingHasARate(){
        assertEquals(30, booking.getRate());
    }

    @Test
    public void getTotalCostOfStayForBooking(){
        assertEquals(90,booking.getTotal());
    }

    @Test
    public void bookingHasAGuest(){
        assertEquals(guest, booking.getGuest());
    }
}
