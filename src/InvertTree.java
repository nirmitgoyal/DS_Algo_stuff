import models.Node;

public class InvertTree {

    Node invert(Node node) {
        if (node == null)
            return null;

        Node temp = invert(node.L);
        node.L = invert(node.R);
        node.R = temp;

        return node;
    }
}
