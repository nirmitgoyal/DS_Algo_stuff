import models.Node;

/*
 *            1
 *          /   \
 *         2     1
 *        /       \
 *       2         1
 * */
public class FilterLeavesBT {
    int target;

    Node deleteLeafWithValueK_Elegant(Node me) {
        if (me == null)
            return null;

        me.L = deleteLeafWithValueK_Elegant(me.L);
        me.R = deleteLeafWithValueK_Elegant(me.R);

        if (isLeaf(me) && me.data == target)
            return null;
        return me;
    }

    boolean toBeDeleted(Node node) {
        if (node == null)
            return false;

        boolean deleteL = toBeDeleted(node.L);
        boolean deleteR = toBeDeleted(node.R);

        if (deleteL)
            node.L = null;
        if (deleteR)
            node.R = null;

        return isLeaf(node) && node.data == target;
    }
}
