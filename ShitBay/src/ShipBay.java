import java.util.*;

/**
 * Created by lilla on 15/01/17.
 */
public class ShipBay {
    Set<Ship> ships = new LinkedHashSet<>();

    public ShipBay() {
        super();
    }

    void receiveShip(Ship ship) {
        if (!ship.isInTheBay) {
            ship.isInTheBay = true;
        }
    }

    void departShip(Ship ship) {
        if (ship.isInTheBay) {
            ship.isInTheBay = false;
        }
    }

    boolean isShipInTheBay(Ship ship) {
        if (ship.isInTheBay) {
            return true;
        }
        return false;
    }

    String shipsSortedByName() {
        String string = "";
        List<Ship> sortedList = new LinkedList<>(ships);
        sortedList.sort(new ShipNameComp());
        for (Ship i:sortedList) {
            if (i.isInTheBay) {
                string += i.getName() + " " + i.getProfit() + "<br>";
            }
        }
        string = "<html><body>" + string + "</body></html>";
        return string;
    }

    String shipsSortedByProfit() {
        String string = "";
        List<Ship> sortedList = new LinkedList<>(ships);
        sortedList.sort(new ShipProfitComp());
        for (Ship i: sortedList) {
            if (i.isInTheBay) {
                string += i.getName() + " " + i.getProfit() + "<br>";
            }
        }
        string = "<html><body>" + string + "</body></html>";
        return string;
    }

    String summaries() {
        String string = "<html><body>" ;
        for (Ship i:ships) {
            string  += i.summary() + "<br>";
        }
        string += "</body></html>";
        return string;
    }

    Ship addShip(Ship ship) {
        if (ships.add(ship)) {
            return ship;
        }
        return null;
    }

    Ship returnShip(String name) {
        for(Ship i:ships) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    boolean getShipType(Ship ship) {
        return ship.getShipType(ship);
    }
}

class ShipNameComp implements Comparator<Ship>{

    @Override
    public int compare(Ship o1, Ship o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class ShipProfitComp implements Comparator<Ship> {

    @Override
    public int compare(Ship o1, Ship o2) {
        return o1.getProfit().compareTo(o2.getProfit());
    }
}