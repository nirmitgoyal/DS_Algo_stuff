import models.Node;

/*
 *            1
 *          /   \
 *         2     1
 *        /       \
 *       2         1
 * */
public class FilterLeavesBT {
    static int deleteValue;

    void toBeDeleted(Node node, int deleteValue) {
        FilterLeavesBT.deleteValue = deleteValue;

        toBeDeleted(node);
        //or
        toBeDeletedElegantCode(node);
    }

    Node toBeDeletedElegantCode(Node node) {
        if (node == null)
            return null;

        node.L = toBeDeletedElegantCode(node.L);
        node.R = toBeDeletedElegantCode(node.R);

        if (isLeaf(node) && node.data = deleteValue)
            return null;
        return node;
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
