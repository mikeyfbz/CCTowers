import org.omg.CORBA.INTERNAL;

public class Booking {

    private Room room;
    private Integer nights;
    private Integer rate;
    private Guest guest;

    public Booking(Room room, Integer nights, Integer rate, Guest guest){
        this.room = room;
        this.nights = nights;
        this.rate = rate;
        this.guest = guest;
    }


    public String getRoomDetails() {
        return this.room.getRoomName();
    }

    public int getNumberOfNights() {
        return this.nights;
    }

    public int getRate() {
        return this.rate;
    }

    public int getTotal() {
        return this.rate * this.nights;
    }

    public Guest getGuest(){
        return this.guest;
    }

}
