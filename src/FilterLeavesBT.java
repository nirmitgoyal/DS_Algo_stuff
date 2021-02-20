import models.Node;

/*
 *            1
 *          /   \
 *         2     1
 *        /       \
 *       2         1
 * */
public class FilterLeavesBT {
    int deleteValue;

    Node toBeDeletedElegantCode(Node me) {
        if (me == null)
            return null;

        me.L = toBeDeletedElegantCode(me.L);
        me.R = toBeDeletedElegantCode(me.R);

        if (isLeaf(me) && me.data == deleteValue)
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

        return isLeaf(node) && node.data == deleteValue;
    }
}
