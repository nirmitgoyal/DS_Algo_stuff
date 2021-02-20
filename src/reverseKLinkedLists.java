import models.Node;

public class reverseKLinkedLists {

//    Input:  1->2->3->4->5->6->NULL, k = 3
//    Output: 3->2->1->6->5->4->NULL
//    use recursive approach
    Node reverseKLinkedLists(Node head, int k) {
        Node //3 new vars
                curr = head,
                prev = null,
                next = null;

        int count = 0;

        while (curr != null && count != k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++; //
        }

        if (next != null) //
            head.next = reverseKLinkedLists(next, k); // head.next, coz head(1) will point to (6)

        return prev;
    }

}
