import java.util.ArrayList;

public class Room {

    private String roomNumber;
    private String roomType;
    private Integer capacity;
    private ArrayList<Guest> guests;
    private Integer roomRate;

    public Room(String roomNumber, String roomType, Integer capacity, Integer roomRate){
        this.roomNumber =roomNumber;
        this.roomType = roomType;
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
        this.roomRate = roomRate;
    }

    public String getRoomName(){
        return this.roomNumber;
    }

    public String getRoomType(){
        return this.roomType;
    }

    public int getCapacity(){
        return  this.capacity;
    }

    public int countGuests() {
        return this.guests.size();
    }

    public void addGuest(Guest guest) {
        if(this.capacity > countGuests()) {
            this.guests.add(guest);
        }
    }

    public Guest removeGuest(Guest guest) {
        if (this.guests.contains(guest)){
            this.guests.remove(guest);
        }
        return guest;
    }

    public int getRoomRate(){
        return this.roomRate;
    }

}
