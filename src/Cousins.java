import models.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cousins {

    List<Node> cousins(Node root, Node node1) {
        List<Node> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int h = -1, d = 0;
        Node parent = null;

        while (!q.isEmpty()) {
            d++;

            int count = q.size();
            for (int times = 0; times < count; times++) {
                Node curr = q.poll();
                if (curr == node1) {
                    h = d;
                    parent = curr.parent;
//                    break;
                }

                for (Node child : curr.childs) {
                    child.parent = curr;
                    q.add(child);
                }
            }
        }

        q.clear();
        q.add(root);
        d = 0;

        while (!q.isEmpty()) {
            d++;

            int count = q.size();
            for (int times = 0; times < count; times++) {
                Node curr = q.poll();

                if (d == h && curr.parent != parent)
                    ans.add(curr);

                for (Node child : curr.childs)
                    q.add(child);
            }
        }

        return ans;
    }
}
/*
      1
    /   \
   2    3
    \  / | \
    4 5  7  6

node1=4
h 3
d 3
q:
parent 2
count 4
curr 7
ans: 5 6 7

*  */