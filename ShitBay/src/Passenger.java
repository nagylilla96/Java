import java.util.*;

/**
 * Created by lilla on 15/01/17.
 */
public class Passenger implements Carriable {
    private final String name;

    public Passenger(String name) {
        this.name = name;
    }

    private Passenger() {
        this(null);
    }
}
