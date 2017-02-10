package lilla;


import java.util.*;

/**
 * Created by lilla on 17/01/17.
 */
public class Shuttle {
    String name;
    Status status;
    final static int MIN_PASSENGERS = 10;
    final static int MAX_PASSENGERS = 80;
    Set<Seat> seats = new LinkedHashSet<>();
    Set<Ticket> tickets = new LinkedHashSet<>();
    Set<Passenger> passengers = new LinkedHashSet<>();
    Route route;
    int profit;
    boolean isInTheStation = false;

    public Shuttle(String name, Status status, int nrOfPassengers) {
        this.name = name;
        this.status = status;
        Random rand = new Random();
        int roadStops = rand.nextInt(10) + 1;
        Destination destination;
        if (nrOfPassengers >= MIN_PASSENGERS && nrOfPassengers <= MAX_PASSENGERS) {
            Passenger passenger;
            destination = new Destination();
            for (int i = 0; i < nrOfPassengers; i++ ) {
                Route route = new Route(roadStops);
                passenger = new Passenger(destination, route);
                passenger.addTicket(new Ticket(route, destination));
                passengers.add(passenger);
            }
            for (int i = 0; i < 80; i++) {
                seats.add(new Seat(destination));
            }
        }
    }

    Float returnProfit() {
        switch (status) {
            case docked:
                return null;
            case departed:
                float sum = 0;
                for (Passenger i : passengers) {
                    if (i.getTicket() == null) {
                        continue;
                    }
                    if (i.getTicket().isSold) {
                        sum += i.getTicket().getTotalPrice();
                    }
                }
                sum -= (0.2) * (MAX_PASSENGERS - passengers.size());
                return sum;
            case arrived:
                return (float) ((0.05) * seats.size());
            default:
                break;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    void setRoute(int nrOfElements) {
        this.route = new Route(nrOfElements);
    }


    public Status getStatus() {
        return status;
    }


    public void setStatus(Status status) {
        this.status = status;

    }

    String listPassengers() {
        String string = "<html><body>" ;
        for (Passenger i:passengers) {
            string  += i.getId() + " " + i.getDestination() + "<br>";
        }
        string += "</body></html>";
        return string;
    }

}
