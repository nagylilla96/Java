/**
 * Created by lilla on 09/02/17.
 */
public class DoublyLinkedList {
    Node first;
    Node last;
    int nrOfElements;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
        this.nrOfElements = 0;
    }

    void insertAsc(Node node) {
        Node ptr = first;
        if (nrOfElements == 0) {
            this.first = node;
            this.last = node;
        }
        while (ptr != this.last && ptr != null && node.compareTo(ptr)>=0) {
            if (ptr != this.last)
            {
                try {
                    ptr = ptr.getNext();
                }
                catch (NullPointerException e) {
                    ptr = this.last;
                }
            }
            else {
                ptr = this.last;
            }
        }
        if (ptr == this.first) {
            this.first.setPrevious(node);
            node.setNext(this.first);
            this.first = node;
            return;
        }
        if (ptr == this.last) {
            if (ptr.compareTo(node) <= 0) {
                this.last.setNext(node);
                node.setPrevious(ptr);
                this.last = node;
            }
            else
            {
                this.last.previous.setNext(node);
                node.setPrevious(this.last.previous);
                this.last.setPrevious(node);
                node.setNext(this.last);
            }
            return;
        }
        if (ptr != null && ptr != this.first && ptr != this.last) {
            ptr.previous.setNext(node);
            node.setPrevious(ptr.previous);
            node.setNext(ptr);
            ptr.setPrevious(node);
        }
        nrOfElements++;
    }
}
