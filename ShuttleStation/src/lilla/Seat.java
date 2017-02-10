package lilla;

import java.util.UUID;

/**
 * Created by lilla on 17/01/17.
 */
public class Seat {

    final String id;
    Shuttle shuttle;
    Passenger passenger;
    Ticket ticket;

    public Seat(Destination destination) {
        this.id = UUID.randomUUID().toString();
    }

    public Shuttle getShuttle() {
        return shuttle;
    }

    public void setShuttle(Shuttle shuttle) {
        this.shuttle = shuttle;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Ticket getTicket() {
        return ticket;

    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
