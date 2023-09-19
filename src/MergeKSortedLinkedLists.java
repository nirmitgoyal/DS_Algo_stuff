import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import lombok.AllArgsConstructor;
import models.Node;

public class MergeKSortedLinkedLists {

  Node mergeKSortedLinkedLists(List<Node> a) {
    Node head = null,
        curr = null;

    Queue<Element> pq = new PriorityQueue<>();
    int k = a.size();
    for (int i = 0; i < k; i++) {
      pq.add(new Element(a.get(i).data, i, 0));
    }

    while (!pq.isEmpty()) {
      Element smallest = pq.poll();

      if (curr == null) {
        head = new Node(smallest.data);
        curr = head;
      } else {
        curr.next = new Node(smallest.data);
        curr = curr.next;
      }

      if (a.get(smallest.linkedListIndex).next != null) {
        pq.add(new Element(a.get(smallest.linkedListIndex).next.data, smallest.linkedListIndex,
            smallest.currNodeIndex + 1));
      }
    }

    return head;
  }

  @AllArgsConstructor
  class Element {

    int data, linkedListIndex, currNodeIndex;
  }
}
