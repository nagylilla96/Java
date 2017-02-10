import org.jetbrains.annotations.NotNull;

/**
 * Created by lilla on 10/02/17.
 */
public class Node implements Comparable<Node> {
    Integer id;
    Node left;
    Node right;

    public Node(Integer id) {
        this.id = id;
        this.left = null;
        this.right = null;
    }

    Node insert(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        }
        if (newNode.compareTo(root) < 0) {
            root.left = insert(root.left, newNode);
        } else {
            root.right = insert(root.right, newNode);
        }
        return root;
    }

    void print(Node node, int level) {
        if (node == null) {
            return;
        }
        print(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(node.id);
        print(node.left, level + 1);
    }

    @Override
    public int compareTo(@NotNull Node o) {
        return this.id.compareTo(o.id);
    }
}
