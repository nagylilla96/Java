import org.jetbrains.annotations.NotNull;

/**
 * Created by lilla on 09/02/17.
 */
public class Node implements Comparable<Node> {
    Integer id;
    Node previous;

    public Node(Integer id) {
        this.id = id;
        this.previous = null;
        this.next = null;
        System.out.println("Node created with id " + id);
    }

    public Integer getId() {
        return id;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;

    }

    public void setNext(Node next) {
        this.next = next;
    }

    Node next;
    @Override
    public int compareTo(@NotNull Node o) {
        return Integer.compare(this.id, o.id);
    }
}
