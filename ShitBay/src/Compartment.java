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
        System.out.println("Compartment added");
    }
    public Compartment() {
        this(false);
    }

    int getProfit() {
        if (passenger) {
            this.profit = carriables.size() * COMPARTMENT_PRICE;
            return this.profit;
        }
        this.profit = 0;
        for (Carriable i:carriables) {
            this.profit += ((CargoItem) i).getProfit();
        }
        return this.profit;

    }

    String getUUID() {
        return this.ID;
    }

    int addCarriable(Object o) {
        if (this.passenger) {
            if (carriables.add((Passenger) o)) return 1;
        }
        else {
            if (carriables.add((CargoItem) o)) return 1;
        }
        return 0;
    }

    Carriable returnCarriable(String name) {
        if (passenger) {
            for (Carriable i:carriables) {
                if (((Passenger) i).getName().equals(name))
                    return i;
            }
        }
        else {
            for (Carriable i:carriables) {
                if (((CargoItem) i).getName().equals(name)){
                    return i;
                }
            }
        }
        return null;
    }
}
