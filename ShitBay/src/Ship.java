import java.util.*;

/**
 * Created by lilla on 15/01/17.
 */
public class Ship {
    protected Set<Compartment> compartments = new LinkedHashSet<>();
    protected String name;
    protected Integer profit = 0;
    protected boolean isInTheBay;

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

    String summary() {
        String string = "Name: " + this.name + " compartments: " + compartments.size() + " profit: " + getProfit();
        return string;
    }
}
