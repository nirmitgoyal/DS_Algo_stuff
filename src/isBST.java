import models.Node;

public class isBST {
    boolean isBST(Node node, Integer minBound, Integer maxBound) {
        if (node == null)
            return true;

        return isBST(node.L, minBound, node.data)
                && isBST(node.R, node.data, maxBound)
                && node.data > minBound && node.data < maxBound;
    }
}
