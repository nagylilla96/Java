import org.jetbrains.annotations.NotNull;

/**
 * Created by lilla on 09/02/17.
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
        while (ptr.next != null && node.compareTo(ptr.next)>0) {
            ptr = ptr.next;
        }
        if (ptr == first) {
            ptr.previous = node;
            node.next = ptr;
            first = node;
            return first;
        }
        if (ptr.next != null) {
            ptr.next.previous = node;
            node.next = ptr.next;
            ptr.next = node;
            node.previous = ptr;
        }
        else {
            ptr.next = node;
            node.previous = ptr;
        }

        return first;
    }

    @Override
    public int compareTo(@NotNull Node o) {
        return Integer.compare(this.id, o.id);
    }
}
