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

        //I got the answer, after the base cases were hit, so now I have to think on what to do with these results
        if (leftSearchResult == null && rightSearchResult == null)
            return null;
        if (leftSearchResult != null && rightSearchResult != null)
            return me;
        else if (leftSearchResult != null)
            return leftSearchResult;
        else
            return rightSearchResult;
    }

    Node LCA_NAryTree(Node me, Node node1, Node node2) { //Time: O(n) Space is also: O(n) //working
        if (me == null)
            return null;

        if (me == node1 || me == node2)
            return me;

        List<Node> searchResult = new ArrayList<>(2); //2 can be the max size //should be a local list only
        for (Node child : me.childs) {
            Node LCA = LCA_NAryTree(child, node1, node2);
            if (LCA != null)
                searchResult.add(LCA);
        }

        if (searchResult.size() == 0)
            return null;
        if (searchResult.size() == 2)
            return me;
        else // searchResult.size() == 1
            return searchResult.get(0);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node _2 = new Node(2);
        Node _3 = new Node(3);
        Node _4 = new Node(4);
        Node _5 = new Node(5);
        Node _6 = new Node(6);
        Node _7 = new Node(7);
        Node _8 = new Node(8);

        root.childs.add(_2);
        root.childs.add(_3);

        _2.childs.add(_4);
        _2.childs.add(_5);
        _2.childs.add(_6);

        _3.childs.add(_7);
        _3.childs.add(_8);

        System.out.println(LCA_NAryTree(root, _7, _2).data);
    }
}
