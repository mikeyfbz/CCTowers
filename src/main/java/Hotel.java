import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private String name;
    private ArrayList<Room> rooms;
    private ArrayList<Booking> allHotelBookings;
    private ArrayList<Room> vacantRooms;

    public Hotel(String name, ArrayList<Room> rooms){
        this.name = name;
        this.rooms = rooms;
        this.allHotelBookings = new ArrayList<Booking>();
        this.vacantRooms = new ArrayList<Room>();
    }


    public String getName() {
        return this.name;
    }

    public int roomCount() {
        return this.rooms.size();
    }

    public void checkInGuest(Guest guest, Room room) {
        for (Booking booking : this.allHotelBookings) {
            if(booking.getGuest() == guest){
                if (checkRoomIsVacant(room) == true) {
                    room.addGuest(guest);
                }
            }
        }
    }

    public int checkRoomOccupancy(Room room) {
        return room.countGuests();
    }

    public void checkOutGuest(Guest guest, Room room) {
        room.removeGuest(guest);
    }

    public Booking bookRoom(Room room, Guest guest, int nights) {
        Booking booking = new Booking(room, nights, room.getRoomRate(), guest);
        saveBooking(booking);
        return booking;
    }

    public void saveBooking(Booking booking){
        this.allHotelBookings.add(booking);
    }

    public int countNumberOfBookings() {
        return this.allHotelBookings.size();
    }

    public int checkVacantRooms() {
        return this.vacantRooms.size();
    }

    public void createVacantRoomList(){
        for(Room room : this.rooms){
            if(checkRoomOccupancy(room) == 0){
                this.vacantRooms.add(room);
            }
        }
    }

    public boolean checkRoomIsVacant(Room room){
        if(room.countGuests() == 0){
            return true;
        } else {
            return false;
        }
    }
}
