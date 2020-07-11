import models.Node;

public class reverseKLinkedLists {
    //    https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
    //    https://www.geeksforgeeks.org/reverse-a-linked-list-in-groups-of-given-size-iterative-approach/
    //    use recursive approach
    Node reverseK(models.Node head) {
        Node
                curr = head,
                prev = null,
                nextNode = null;
        int count = 0;

        //reverse linked list using iterative approach
        while (curr != null && count != k) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            count++;
        }

        if (nextNode != null) //
            head.next = reverseK(nextNode); //

        return prev; //
    }

}
