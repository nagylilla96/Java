import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lilla on 17/01/17.
 */
public class IOFile {

    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        in = new FileInputStream("input.txt");
        out = new FileOutputStream("output.txt");
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        if (in != null) {
            in.close();
        }
        if (out != null) {
            out.close();
        }
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        Scanner scanner = new Scanner(new File("input.txt"));
        List<String> list = new ArrayList<String>();
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        for (String i:list) {
            System.out.println(i);
        }
    }
}
