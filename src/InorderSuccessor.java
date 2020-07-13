import models.Node;

public class InorderSuccessor {

    //TODO: validations
    Node InorderSuccessor(Node node, int value) {
        Node curr = search(node, value);

        return nextGreater(node);
    }

    private Node nextGreater(Node node) {
        Node me;

        if (node.R != null) {
            me = node.R;

            while (me.L != null) {
                me = me.L;
            }
            return me;
        } else {
            me = node;
            Node parentNode = node.parent;

            while (parentNode != null && parentNode.L != me) {
                me = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode;
        }
    }
}
