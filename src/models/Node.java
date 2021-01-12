package models;

import java.util.Arrays;
import java.util.List;

public class Node {
    public Integer data;
    public Node L, R,
            nextRight,
            prev, next,
            parent;
    public List<Node> childs;

    public Node(Integer item) {
        data = item;
        L = R = nextRight = null;
        childs = Arrays.asList(null, null); //atleast 2 null elements should be there, other wise it's a linkedList or a BTree
    }

    public Node(int data, Node L, Node R) {
        this.data = data;
        this.L = L;
        this.R = R;
    }
}
