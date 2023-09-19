import java.util.HashMap;
import java.util.Map;
import models.ListNode;
import models.Node;

public class RemoveZeroSumConsecutiveLLNodes {

  /*
  1 2 -3 3 1

  0->dummy
  1->1
  3->2
  0->-3
  3->3
  4->1

  dummy->3->1
   */
  ListNode removeZeroSumConsecutiveLLNodes(ListNode head) {
    int prefixSum = 0;
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    Map<Integer, ListNode> seen = new HashMap<>();
    for (ListNode i = dummy; i != null; i = i.next) {
      prefixSum += i.data;
      seen.put(prefixSum, i);
    }

    prefixSum = 0;
    for (ListNode i = dummy; i != null; i = i.next) {
      prefixSum += i.data;
      i.next = seen.get(prefixSum).next;
    }

    return dummy.next;
  }
}
