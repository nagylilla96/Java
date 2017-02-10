import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by lilla on 10/02/17.
 */
public class Bear {
    List<Hole> holeList = new LinkedList<>();
    int positionx;
    int positiony;
    int steps;
    int waiting;

    public Bear(int positionx, int positiony) {
        this.positionx = positionx;
        this.positiony = positiony;
        this.steps = 0;
        setWaiting();
    }

    void setWaiting() {
        Random rand = new Random();
        this.waiting = rand.nextInt(5) + 2;
    }

    void move() {
        Random rand = new Random();
        int number = rand.nextInt(holeList.size() + 1);
        this.positionx = holeList.get(number).positionx;
        this.positiony = holeList.get(number).positiony;
    }
}
