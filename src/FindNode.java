import models.Node;

import java.util.LinkedList;
import java.util.Queue;

public class FindNode {

    Node findNode(Node node1, Node node2, Node targetNode) {
        if (targetNode == null || node1 == null || node2 == null)
            return null;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(node1);
        q2.add(node2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            Node curr1 = q1.poll();
            Node curr2 = q2.poll();

            if (curr1 == targetNode)
                return curr2;

            if (curr1.L != null)
                q1.add(curr1.L);
            if (curr2.L != null)
                q1.add(curr2.L);

            if (curr1.R != null)
                q1.add(curr1.R);
            if (curr2.R != null)
                q1.add(curr2.R);
        }

        return null;
    }
}
