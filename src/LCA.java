import models.Node;

import java.util.ArrayList;
import java.util.List;

public class LCA {

    Node LCA_BTree(Node me, Node node1, Node node2) {
        //in these 2 cases too, i'm pushing myself up
        if (me == null)
            return null;

        if (me == node1 || me == node2)
            return me;

        //recursion will pull the situation down till leaves
        Node leftSearchResult = LCA_BTree(me.L, node1, node2);
        Node rightSearchResult = LCA_BTree(me.R, node1, node2);

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

    Node LCA_NAryTree(Node me, Node node1, Node node2) { //Time: O(n) Space is also: O(n)
        if (me == null)
            return null;

        if (me == node1 || me == node2)
            return me;

        List<Node> searchResult = new ArrayList<>();
        for (Node child : me.childs)
            searchResult.add(LCA_NAryTree(child, node1, node2));

        //atleast 2 null elements should be there in searchResult, otherwise the given tree is a linkedList or a BTree
        if (searchResult.get(0) == null && searchResult.get(1) == null)
            return null;
        if (searchResult.get(0) != null && searchResult.get(1) != null)
            return me;
        else if (searchResult.get(0) != null)
            return searchResult.get(0);
        else
            return searchResult.get(1);
    }
}
