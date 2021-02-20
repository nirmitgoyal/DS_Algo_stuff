import models.Node;

public class InorderSuccessor {

    Node InorderSuccessor(Node root, int value) {
        Node node = search(root, value); //log n

        return nextGreater(node);
    }

    private Node nextGreater(Node me) {
        Node curr;

        if (me.R != null) {
            curr = me.R;

            while (curr.L != null)
                curr = curr.L;

            return curr;
        } else {
            curr = me;
            Node parentNode = me.parent;

            while (parentNode != null && parentNode.L != curr) {
                curr = parentNode;
                parentNode = parentNode.parent;
            }

            return parentNode;
        }
    }
}
