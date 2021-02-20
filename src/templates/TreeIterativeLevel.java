package templates;

import models.Node;

import java.util.LinkedList;
import java.util.Queue;

public class TreeIterativeLevel {

    void LOT(Node root) {
        if (root == null)
            return ;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while (true) {
            int count = q.size();

            if (count == 0)
                break;

            //every level
            level++;

            while (count > 0) {
                Node node = q.poll();

                if (node.L != null)
                    q.add(node.L);
                if (node.R != null)
                    q.add(node.R);

                count--;
            }
        }
    }
}
