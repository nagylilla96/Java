import java.util.*;

/**
 * Created by lilla on 15/01/17.
 */
public class Ship {
    protected Set<Compartment> compartments = new LinkedHashSet<>();
    protected String name;
    protected Integer profit = 0;
    protected boolean isInTheBay;
    protected boolean passenger;

    public Ship(String name) {
        this.name = name;
        this.isInTheBay = false;
        System.out.println("Ship added");
    }

    String getName() {
        return this.name;
    }

    Integer getProfit() {
        profit = 0;
        for (Compartment i: compartments) {
            profit += i.getProfit();
        }
        return profit;
    }

    Compartment addCompartment(Compartment compartment) {
        if (compartments.add(compartment)) {
            return compartment;
        }
        return null;
    }

    boolean getShipType(Ship ship) {
        if (compartments.iterator().hasNext()) {
            Compartment compartment = compartments.iterator().next();
            if (compartment.isPassenger()) {
                return true;
            }
            return false;
        }
        return false;
    }

    void setShipType() {
        if(compartments.iterator().hasNext()) {
            if(compartments.iterator().next().isPassenger()) {
                this.passenger = true;
            }
            else {
                this.passenger = false;
            }
        }
    }

    String summary() {
        String string = "Name: " + this.name + " compartments: " + compartments.size() + " profit: " + getProfit();
        return string;
    }
}
