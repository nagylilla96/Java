import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by lilla on 10/02/17.
 */
public class Seal {
    int positionx;
    int positiony;
    int steps;
    boolean tookBreath;
    int waiting;
    List<Hole> holeList = new LinkedList<>();

    public Seal(int positionx, int positiony) {
        this.positionx = positionx;
        this.positiony = positiony;
        this.steps = 0;
        this.tookBreath = false;
        setWaiting();
    }

    void setWaiting() {
        Random rand = new Random();
        this.waiting = rand.nextInt(6) + 1;
    }

    void moveUnderWater() {
        Random rand = new Random();
        this.positionx = rand.nextInt(11);
        this.positiony = rand.nextInt(21);
    }

    void moveToHole() {
        Random rand = new Random();
        int number = rand.nextInt(holeList.size() + 1);
        System.out.println("number = " + number);
        this.positionx = holeList.get(number).positionx;
        this.positiony = holeList.get(number).positiony;
    }
}
