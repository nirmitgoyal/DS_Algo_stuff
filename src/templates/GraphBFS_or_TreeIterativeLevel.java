package templates;

import models.Node;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS_or_TreeIterativeLevel {

    void BFS(Node root) {
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

            for (int times = 0; times < count; times++) {
                Node node = q.poll(); //poll here

                if (node.L != null)
                    q.add(node.L);
                if (node.R != null)
                    q.add(node.R);
            }
        }
    }
}
