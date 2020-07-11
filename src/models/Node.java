package models;

public class Node {
    public Integer data;
    public Node left, right, nextRight, prev, next;

    public Node(Integer item) {
        data = item;
        left = right = nextRight = null;
    }

    public Node(int data, Node left, Node right) {
        this.data=data;
        this.left=left;
        this.right=right;
    }
}
