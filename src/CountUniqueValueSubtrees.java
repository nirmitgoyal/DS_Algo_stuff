import models.Node;

public class CountUniqueValueSubtrees {
    int countUniqueValueSubtrees(Node node) {
        return countUniqueValueSubtreesHelper(node).count;
    }

    private Return countUniqueValueSubtreesHelper(Node node) {
        if (node == null)
            return new Return(true, 0);

        Return left = countUniqueValueSubtreesHelper(node.L);
        Return right = countUniqueValueSubtreesHelper(node.R);

        if (left.isUniqueValue && right.isUniqueValue && (node.L == null || node.data == node.L.data) && (node.R == null || node.data == node.R.data))
            return new Return(true, left.count + right.count + 1);
        else
            return new Return(false, left.count + right.count);
    }

    class Return {
        boolean isUniqueValue;
        int count;

        public Return(boolean isUniqueValue, int count) {
        }
    }
}
