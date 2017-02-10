/**
 * Created by lilla on 09/02/17.
 */
public class Main {
    public static void main(String args[]) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAsc(new Node(3));
        dll.insertAsc(new Node(2));
        dll.insertAsc(new Node(9));
        dll.insertAsc(new Node(5));
        dll.insertAsc(new Node(7));
        dll.insertAsc(new Node(1));
        dll.insertAsc(new Node(4));
        Node ptr = dll.first;
        while (ptr != null) {
            System.out.println(ptr.getId());
            if (ptr != dll.last) {
                ptr = ptr.getNext();
            }
            else {
                ptr = null;
            }
        }
    }
}
