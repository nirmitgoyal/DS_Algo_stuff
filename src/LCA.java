import models.Node;

public class LCA {

    Node LCA(Node me, Node node1, Node node2) {
        //in these 2 cases too, i'm pushing myself up
        if (me == null)
            return null;

        if (me == node1 || me == node2)
            return me;

        //recursion will pull the situation down till leaves
        Node leftSearchResult = LCA(me.L, node1, node2);
        Node rightSearchResult = LCA(me.R, node1, node2);

        //in these 4 cases too, i'm pushing myself up
        if (leftSearchResult == null && rightSearchResult == null)
            return null;
        if (leftSearchResult != null && rightSearchResult != null)
            return me;
        else if (leftSearchResult != null)
            return leftSearchResult;
        else
            return rightSearchResult;
    }
}
