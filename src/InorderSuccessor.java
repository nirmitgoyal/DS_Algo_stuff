import models.Node;

public class InorderSuccessor {

    //TODO: validations
    Node InorderSuccessor(Node root, int value) {
        Node node = search(root, value); //log n

        return nextGreater(node);
    }

    private Node nextGreater(Node node) {
        Node curr;

        if (node.R != null) {
            curr = node.R;

            while (curr.L != null)
                curr = curr.L;

            return curr;
        } else {
            curr = node;
            Node parentNode = node.parent;

            while (parentNode != null && parentNode.L != curr) {
                curr = parentNode;
                parentNode = parentNode.parent;
            }

            return parentNode;
        }
    }
}
