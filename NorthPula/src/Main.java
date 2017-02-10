import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by lilla on 10/02/17.
 */
public class Main {
    public static void main(String args[]) throws IOException {
        GivenMethods giv = new GivenMethods();
        Logger logger = Logger.getLogger(Main.class.getName());
        System.out.println(Integer.parseInt(args[0]));
        logger.log(Level.ALL, "" + Integer.parseInt(args[0]));
        int bears[] = new int[]{0};
        int seals[] = new int[]{0};
        int holes[] = new int[]{0};
        try {
            if (args.length != 2) {
                throw new SizeOutOfBoundsException("Too many arguments!");
            }
        }
        catch (SizeOutOfBoundsException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        bears = giv.getBearPos();
        seals = giv.getSealPos();
        holes = giv.getHolePos();
        Lake lake = new Lake(Integer.parseInt(args[0]), Integer.parseInt(args[1]), seals.length/2, holes.length/2);

        lake.addBear(bears);
        lake.addHoles(holes);
        lake.addSeals(seals);
        Scanner scanner = new Scanner(System.in);
        int steps = 0;
        while (steps <= 300 && lake.sealList.size() != 0) {
            if (scanner.hasNextLine()){
                scanner.nextLine();
                lake.newTurn();
                steps++;
                System.out.println("Enter pressed!");
                for (int i = 0; i < lake.rows; i++) {
                    for (int j = 0; j < lake.columns; j++) {
                        Seal mySeal = new Seal(i, j);
                        Bear myBear = new Bear(i, j);
                        Hole myHole = new Hole(i, j);
                        if (lake.sealList.contains(mySeal)){
                            if (lake.holeList.contains(myHole)) {
                                System.out.print("S");
                            }
                            else {
                                System.out.print("s");
                            }
                        }
                        else {
                            if (lake.bear.positionx == i && lake.bear.positiony == j && lake.holeList.contains(myBear)){
                                System.out.print("B");
                            }
                            else {
                                if (lake.holeList.contains(myHole)){
                                    System.out.print("H");
                                }
                                else System.out.print(".");
                            }
                        }
                    }
                    System.out.println();
                }
            }

        }
    }
}
