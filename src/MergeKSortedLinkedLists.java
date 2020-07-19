import models.Node;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    Node mergeKSortedLinkedLists(ArrayList<Node> a) {
        Node head = null, curr = null;

        PriorityQueue<Element> pq = new PriorityQueue<>();
        for (int i = 0; i < a.size(); i++)
            pq.add(new Element(a.get(i).data, i, 0));

        while (!pq.isEmpty()) {
            Element smallest = pq.poll();

            if (curr == null) {
                head = new Node(smallest.data);
                curr = head;
            } else {
                curr.next = new Node(smallest.data);
                curr = curr.next;
            }

            int arrayListIndex = smallest.arrayListIndex;
            int indexOfCurrList = smallest.indexOfCurrList;

            if (a.get(arrayListIndex).next != null)
                pq.add(new Element(a.get(arrayListIndex).next.data, arrayListIndex, indexOfCurrList + 1));
        }

        return head;
    }

    class Element {
        int data, arrayListIndex, indexOfCurrList;

        public Element(int data, int i, int i1) {
        }
    }
}
