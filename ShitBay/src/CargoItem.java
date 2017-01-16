import java.util.*;

/**
 * Created by lilla on 15/01/17.
 */
public class CargoItem implements Carriable {
    private final String name;
    private final int profit;

    public CargoItem(String name, int profit) {
        this.name = name;
        this.profit = profit;
        System.out.println("CargoItem added");
    }

    String getName(){
        return this.name;
    }

    int getProfit() {
        return this.profit;
    }

    public CargoItem() {
        this(null, 0);
    }
}
