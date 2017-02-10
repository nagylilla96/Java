/**
 * Created by lilla on 10/02/17.
 */
public class Main {

    public static void main(String args[]) {
        Node root = new Node(5);
        root = root.insert(root, new Node(3));
        root = root.insert(root, new Node(7));
        root = root.insert(root, new Node(2));
        root = root.insert(root, new Node(6));
        root = root.insert(root, new Node(1));
        root.print(root, 0);
    }
}
