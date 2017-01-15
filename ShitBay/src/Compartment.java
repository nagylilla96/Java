import java.util.*;

/**
 * Created by lilla on 15/01/17.
 */
public class Compartment {
    protected final String ID;
    protected final boolean passenger;
    protected int profit = 0;
    protected static final int COMPARTMENT_PRICE = 100;
    protected static final int MAX_PASSENGERS = 100;
    List<Carriable> carriables = new LinkedList<>();

    public Compartment(boolean passenger) {
        this.ID = UUID.randomUUID().toString();
        if (passenger) {
            this.passenger = true;
        }
        else {
            this.passenger = false;
        }
    }

    int getProfit() {
        this.profit = carriables.size() * COMPARTMENT_PRICE;
        return this.profit;
    }
}
