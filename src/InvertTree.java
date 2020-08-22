import models.Node;

public class InvertTree {

    Node invert(Node node){
        if (node==null)
            return null;

        Node left=invert(node.L);
        Node right=invert(node.R);
        node.L =right;
        node.R=left;

        return node;
    }
}
