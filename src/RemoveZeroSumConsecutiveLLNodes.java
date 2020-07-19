import models.Node;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveLLNodes {

    Node removeZeroSumConsecutiveLLNodes(Node head) {
        Node dummy = new Node(null);
        dummy.next = head;

        Node curr = head;

        Map<Integer, Node> map = new HashMap<>();

        int sum = 0;

        while (curr != null) {
            sum += curr.data;

            if (map.containsKey(sum)) {
                Node prev = map.get(sum);
                Node nextNode = curr.next;
                Node curr2 = prev.next;

                while (curr2 != nextNode) {
                    int sumToRemove = prev.data + curr2.data;
                    map.remove(sumToRemove);
                    curr2=curr2.next;
                }
                prev.next = nextNode;
            } else {
                map.put(sum, curr);
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
