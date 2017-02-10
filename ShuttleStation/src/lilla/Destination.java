package lilla;

import java.util.UUID;

/**
 * Created by lilla on 17/01/17.
 */
public class Destination {
    final String id;

    public Destination() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
