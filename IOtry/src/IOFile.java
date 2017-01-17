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

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            bw.write(line);
            bw.newLine();
        }
        Scanner scanner = new Scanner(new File("input.txt"));
        PrintStream outp = new PrintStream(new FileOutputStream("output.txt"));
        List<String> list = new ArrayList<String>();
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        for (String i:list) {
            System.out.println(i);
            outp.println(i);
        }
        if (out != null) {
            out.close();
        }
    }
}
