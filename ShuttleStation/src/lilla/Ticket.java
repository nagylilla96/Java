package lilla;

import java.util.UUID;

/**
 * Created by lilla on 17/01/17.
 */
public class Ticket {
    final String ticketID;
    final Destination destination;
    static final double PRICE = 4.5;
    Route route;
    Passenger passenger;
    Shuttle shuttle;
    Seat seat;
    boolean isSold = false;
    double totalPrice = 0;

    public Ticket(Route route, Destination destination) {
        this.ticketID = UUID.randomUUID().toString();
        this.destination = destination;
        this.route = route;
    }

    void sell(Passenger passenger, Shuttle shuttle, Seat seat) {
        passenger.addTicket(this);
        this.passenger = passenger;
        this.shuttle = shuttle;
        this.seat = seat;
        this.isSold = true;
    }


    public String getTicketID() {
        return ticketID;
    }

    public Destination getDestination() {
        return destination;
    }

    public double getPRICE() {
        return this.totalPrice;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Shuttle getShuttle() {
        return shuttle;
    }

    public Seat getSeat() {
        return seat;
    }

    void setRoute(Route route, Destination destination) {
        this.route = route;
        int nrOfStops = 0;
        for (Destination i: route.returnRoute()) {
            nrOfStops++;
            if (i.getId().equals(destination.getId())) {
                destination = i;
            }
        }
        this.totalPrice = PRICE * nrOfStops;
    }

    double getTotalPrice() {
        setRoute(this.route, this.destination);
        return this.totalPrice;
    }

}
