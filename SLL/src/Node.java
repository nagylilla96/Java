/**
 * Created by lilla on 10/02/17.
 */
public class Node implements Comparable<Node> {
    Integer id;
    Node previous;
    Node next;

    public Node(Integer id) {
        this.id = id;
        this.previous = null;
        this.next = null;
        System.out.println("Node created with id " + id);
    }

    Node insertAsc(Node first, Node node) {
        Node ptr = first;
        while (ptr.next != null && node.compareTo(ptr.next) > 0) {
            ptr = ptr.next;
        }
        if (ptr == first) {
            if (node.compareTo(ptr) < 0) {
                node.next = ptr;
                first = node;
            }
        }
        else {
            node.next = ptr.next;
            ptr.next = node;
        }
        return first;
    }

    public int compareTo(Node o) {
        return Integer.compare(this.id, o.id);
    }
}
