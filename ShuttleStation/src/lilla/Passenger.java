package lilla;

import java.util.UUID;

/**
 * Created by lilla on 17/01/17.
 */
public class Passenger {
    final String id;
    final Destination destination;
    Ticket ticket;
    Route route;

    public Passenger(Destination destination, Route route) {
        this.id = UUID.randomUUID().toString();
        this.destination = destination;
        this.route = route;
        this.ticket = new Ticket(route, destination);
        addTicket(this.ticket);
    }

    int addTicket(Ticket ticket) {
        if (!ticket.isSold) {
            ticket.passenger = this;
            ticket.isSold = true;
            return 1;
        }
        return 0;
    }

    Ticket getTicket() {
        return this.ticket;
    }

    public String getId() {
        return id;
    }

    public Destination getDestination() {
        return destination;
    }
}
