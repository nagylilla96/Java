/**
 * Created by lilla on 09/02/17.
 */
public class Main {
    public static void main(String args[]) {
        Node first = new Node(3);
        first = first.insertAsc(first, new Node(3));
        first = first.insertAsc(first, new Node(2));
        first = first.insertAsc(first, new Node(9));
        first = first.insertAsc(first, new Node(5));
        first = first.insertAsc(first, new Node(7));
        first = first.insertAsc(first, new Node(1));
        first = first.insertAsc(first, new Node(4));
        Node ptr = first;
        while (ptr != null) {
            System.out.println(ptr.id);
                ptr = ptr.next;
        }
    }
}
