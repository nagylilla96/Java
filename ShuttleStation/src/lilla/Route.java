package lilla;

import com.google.common.collect.ImmutableList;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lilla on 17/01/17.
 */
public class Route {
    Set<Destination> destinationList = new LinkedHashSet<>();
    ImmutableList<Destination> destinations;

    public Route(int nrOfDestinations) {
        if (nrOfDestinations >= 1 && nrOfDestinations <= 10) {
            for ( int i = 0; i < nrOfDestinations; i++) {
                destinationList.add(new Destination());
            }
        }
    }

    int addRoute(Destination destination) {
        if (destinationList.add(destination)) {
            return 1;
        }
        return 0;
    }

    ImmutableList<Destination> returnRoute() {
        destinations = ImmutableList.copyOf(destinationList);
        return destinations;
    }

}
