package lilla;

import org.apache.batik.util.DoublyLinkedList;

import java.util.*;

/**
 * Created by lilla on 17/01/17.
 */
public class Station {
    Set<Shuttle> shuttleSet = new LinkedHashSet<>();
    float profit;

    int addShuttle(Shuttle shuttle) {
        if (shuttleSet.add(shuttle)) {
            return 1;
        }
        return 0;
    }

    int arriveShuttle(Shuttle shuttle) {
        if (shuttle.getStatus() == Status.departed || shuttle.getStatus() == Status.docked) {
            shuttle.setStatus(Status.arrived);
            profit += shuttle.returnProfit();
            System.out.println("profit " + profit);
            return 1;
        }
        return 0;
    }

    int departShuttle(Shuttle shuttle) {
        if (shuttle.getStatus() == Status.arrived || shuttle.getStatus() == Status.arrived.docked) {
            shuttle.setStatus(Status.departed);
            profit += shuttle.returnProfit();
            System.out.println("profit " + profit);
            return 1;
        }
        return 0;
    }

    int dockShuttle(Shuttle shuttle) {
        if (shuttle.getStatus() == Status.arrived || shuttle.getStatus() == Status.departed) {
            shuttle.setStatus(Status.docked);
            return 1;
        }
        return 0;
    }

    Status checkStatus(Shuttle shuttle) {
        return shuttle.getStatus();
    }

    float returnProfit() {
        float sum = 0;
        for (Shuttle i: shuttleSet) {
            sum += i.returnProfit();
        }
        return sum;
    }

    String[] getShuttles() {
        String [] array = new String[100];
        int x = 0;
        for (Shuttle i: shuttleSet) {
            array[x] = i.getName();
            x++;
        }
        return array;
    }

    Shuttle getShuttle(String name) {
        for (Shuttle i : shuttleSet) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    String createSummary() {
        String string = "<html><body>" ;
        for (Shuttle i:shuttleSet) {
            float number;
            if (i.returnProfit() == null) {
                number =  0;
            }
            else {
                number = i.returnProfit();
            }
            string  += i.getName() + " " + i.getStatus() + " " + number + "<br>";
        }
        string += "</body></html>";
        return string;
    }

    String sortedByProfit() {
        String string = "";
        List<Shuttle> sortedList = new LinkedList<>(shuttleSet);
        sortedList.sort(new ShuttleProfitComp());
        for (Shuttle i: sortedList) {
            float number;
            if (i.returnProfit() == null) {
                number =  0;
            }
            else {
                number = i.returnProfit();
            }
            string += i.getName() + " " + i.getStatus() + " " + number + "<br>";
        }
        string = "<html><body>" + string + "</body></html>";
        return string;
    }

}

class ShuttleProfitComp implements Comparator<Shuttle> {

    @Override
    public int compare(Shuttle o1, Shuttle o2) {
        if (o1.returnProfit() == null) {
            return -1;
        } else {
            if (o2.returnProfit() == null) {
                return 1;
            } else {
                if (o1.returnProfit() == null && o2.returnProfit() == null) {
                    return 0;
                }
            }

            return o1.returnProfit().compareTo(o2.returnProfit());
        }
    }
}
