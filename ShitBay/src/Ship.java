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
    }

    String getName() {
        return this.name;
    }

    Integer getProfit() {
        for (Compartment i: compartments) {
            profit += i.getProfit();
        }
        return profit;
    }

    String summary() {
        String string = "Name: " + this.name + " compartments: " + compartments.size() + " profit: " + getProfit();
        return string;
    }
}
