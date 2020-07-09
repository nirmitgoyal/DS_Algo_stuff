import models.Node;

public class isBST {
    Boolean isBST(Node node, Integer minBound, Integer maxBound) {
        //base
        if (node == null)
            return true;

        return

                node.data > minBound
                && node.data <= maxBound
                && isBST(node.left, minBound, node.data)
                && isBST(node.right, node.data, maxBound);
    }
}
