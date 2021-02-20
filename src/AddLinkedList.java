import models.Node;

public class AddLinkedList {

    Node sum(Node head1, Node head2) {
        Node head = null;
        Node curr = null;
        Node curr1 = head1; //good to copy head to newly created nodes
        Node curr2 = head2;

        int carry = 0, sum;

        while (curr1 != null || curr2 != null) {
            sum = carry + (curr1 != null ? curr1.data : 0) + (curr2 != null ? curr2.data : 0);
            carry = sum / 10;

            int value = sum % 10;
            if (curr == null) {
                head = curr = new Node(value);
            } else {
                curr.next = new Node(value);
                curr = curr.next;
            }

            if (curr1 != null)
                curr1 = curr1.next;
            if (curr2 != null)
                curr2 = curr2.next;
        }

        if (carry > 0)
            curr.next = new Node(carry);

        return head;
    }

}

