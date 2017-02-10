import java.util.LinkedList;
import java.util.List;

/**
 * Created by lilla on 10/02/17.
 */
public class Lake {
    int rows;
    int columns;
    int seals;
    int holes;
    Bear bear;
    List<Hole> holeList = new LinkedList<>();
    List<Seal> sealList = new LinkedList<>();

    public Lake(int rows, int columns, int seals, int holes) {
        try {
            if (rows >= 10 && rows <= 12) {
                this.rows = rows;
            } else {
                throw new SizeOutOfBoundsException("Rows out of bounds!");
            }
            if (columns >= 20 && columns <= 22) {
                this.columns = columns;
            } else {
                throw new SizeOutOfBoundsException("Columns out of bounds!");
            }
            if (seals >= 3 && seals <= 7) {
                this.seals = seals;
            } else {
                throw new SizeOutOfBoundsException("Seals out of bounds!");
            }
            if (holes >= 2 && holes <= 6) {
                this.holes = holes;
            } else {
                throw new SizeOutOfBoundsException("Holes out of bounds!");
            }
        } catch (SizeOutOfBoundsException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    void addBear(int[] bears) {
        for (int i = 0; i < bears.length; i += 2) {
            this.bear = new Bear(bears[0], bears[1]);
        }
    }

    void addHoles(int[] holes) {
        for (int i = 0; i < holes.length; i += 2) {
            holeList.add(new Hole(holes[i], holes[i + 1]));
        }
    }

    void addSeals(int[] seals) {
        for (int i = 0; i < seals.length; i += 2) {
            sealList.add(new Seal(seals[i], seals[i + 1]));
        }
    }

    void newTurn() {
        Seal isBear = new Seal(bear.positionx, bear.positiony);
        if (bear.waiting == 0 && bear.steps > 3) {
            bear.move();
            bear.steps = 0;
            bear.setWaiting();
        }
        else {
            bear.steps++;
            bear.waiting--;
        }
        for (Seal s: sealList) {
            if (s.tookBreath = true) {
                s.tookBreath = false;
                s.moveUnderWater();
                s.steps = 0;
            }
            //seals move to random holes
            if (s.equals(isBear) && bear.steps > 3) {
                sealList.remove(s);
                bear.steps = 0;
                bear.setWaiting();
            }
            s.steps++;
            if (s.steps > 5)
                sealList.remove(s);
            if (s.waiting == 0) {
                s.moveToHole();
                s.setWaiting();
                s.tookBreath = true;
            }
            s.waiting--;
        }
    }
}
