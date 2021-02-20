package models;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
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
        childs = new ArrayList<>();
    }

    public Node(int data, Node L, Node R) {
        this.data = data;
        this.L = L;
        this.R = R;
    }
}
