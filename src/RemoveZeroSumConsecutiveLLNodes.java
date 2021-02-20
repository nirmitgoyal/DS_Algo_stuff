import models.Node;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveLLNodes {

    Node removeZeroSumConsecutiveLLNodes(Node head) {
        Node dummy = new Node(null);
        dummy.next = head;

        Node curr = head;
        Map<Integer, Node> map = new LinkedHashMap<>();
        int sum = 0;

        while (curr != null) {
            sum += curr.data;

            if (map.containsKey(sum)) {
                Node prev = map.get(sum);
                Node next = curr.next;

                //remove all nodes from the map after prev, to not have the stale data
                Node curr2 = prev.next;
                while (curr2 != next) {
                    int sumToRemove = prev.data + curr2.data;
                    map.remove(sumToRemove);
                    curr2 = curr2.next;
                }

                //manipulate LL pointer
                prev.next = next;
            } else
                map.put(sum, curr);

            curr = curr.next;
        }

        return dummy.next;
    }
}
