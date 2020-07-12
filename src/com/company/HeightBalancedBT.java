package com.company;

public class HeightBalancedBT {
    static boolean isBalanced = true;

    int height1(Node node) {
        if (node == null)
            return 0;

        int LSTH = height1(node.L);
        int RSTH = height1(node.R);

        if (Math.abs(LSTH - RSTH) > 1)
            isBalanced = false;

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
}
