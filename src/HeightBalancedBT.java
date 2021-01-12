import models.Node;

public class HeightBalancedBT {
    boolean IS_BALANCED = true;

    int height1(Node node) {
        if (node == null)
            return 0;

        int LSTH = height1(node.L);
        int RSTH = height1(node.R);

        if (Math.abs(LSTH - RSTH) > 1)
            IS_BALANCED = false;

        return (Math.max(LSTH, RSTH) + 1);
    }

    int height2(Node node) {
        if (node == null)
            return 0;

        int LSTH = height2(node.L);
        int RSTH = height2(node.R);

        if (Math.abs(LSTH - RSTH) > 1
                || LSTH == -1
                || RSTH == -1)
            return -1;

        return (Math.max(LSTH, RSTH) + 1);
    }

    boolean height3(Node node) {
        return height3Helper(node).isBalanaced;
    }

    private Return height3Helper(Node node) {
        if (node == null)
            return new Return(true, 0);

        Return leftReturn = height3Helper(node.L);
        Return rightReturn = height3Helper(node.R);

        return new Return((Math.abs(leftReturn.h - rightReturn.h) <= 1
                && leftReturn.isBalanaced
                && rightReturn.isBalanaced),
                (Math.max(leftReturn.h, rightReturn.h) + 1));
    }

    static class Return {
        public boolean isBalanaced;
        public int h;

        public Return(boolean isBalanaced, int h) {
        }
    }
}
