package models;

public class Node {
    public Integer data;
    public Node L, R,
            nextRight,
            prev, next,
            parent;

    public Node(Integer item) {
        data = item;
        L = R = nextRight = null;
    }

    public Node(int data, Node L, Node R) {
        this.data = data;
        this.L = L;
        this.R = R;
    }
}
