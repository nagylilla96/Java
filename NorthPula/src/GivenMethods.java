import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lilla on 10/02/17.
 */
public class GivenMethods {
    public static int[] getArrayOfInts(String filename) throws IOException {
        Scanner intScanner = null;
        try{
            intScanner = new Scanner(new File(filename));
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (intScanner.hasNextInt()) {
                arrayList.add(intScanner.nextInt());
            }
            int[] ret = new int[arrayList.size()];
            for (int i=0; i < ret.length; i++)
            {
                ret[i] = arrayList.get(i).intValue();
            }
            return ret;
        }catch (IOException e) {
            throw e;
        }finally {
            if(intScanner != null) {
                intScanner.close();
            }
        }
    }

    public static int[] getBearPos() throws IOException{
        return getArrayOfInts("bears.txt");
    }

    public static int[] getSealPos() throws IOException{
        return getArrayOfInts("seals.txt");
    }

    public static int[] getHolePos() throws IOException{
        return getArrayOfInts("holes.txt");
    }
}
