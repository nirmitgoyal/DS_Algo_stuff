import models.Node;

public class isBST {
    boolean isBST(Node node, Integer minBound, Integer maxBound) {
        if (node == null)
            return true;

        return node.data > minBound && node.data < maxBound
                && isBST(node.L, minBound, node.data)
                && isBST(node.R, node.data, maxBound);
    }
}
