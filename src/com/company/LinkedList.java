package com.company;

public class LinkedList {
    private static models.Node head;

    //    https://www.geeksforgeeks.org/given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/

    //    https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
    //    https://www.youtube.com/watch?v=_BG9rjkAXj8
    //    1 method to detect loop. 2 methods(method 1 and 2) to remove loop

    //    https://www.geeksforgeeks.org/remove-nth-node-from-end-of-the-linked-list/
    //    https://www.geeksforgeeks.org/delete-nth-node-from-the-end-of-the-given-linked-list/
    //    2nd method; in single traversal:
    void deleteKthLast(int n) {
        if (n == 0)
            return;

        models.Node p1 = head, p2 = head;
        int count = 0;

        while (count <= n) {

            if (p2 == null) {

                if (count == n) {//1
                    head = head.next;
                }

                return;//2
            }

            p2 = p2.next;
            count++;
        }

        //move both forward
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        deleteNext(p1);
    }

    //    https://www.youtube.com/watch?v=sYcOK51hl-A
    //    https://www.geeksforgeeks.org/reverse-a-linked-list/
    models.Node iterativeReverse(models.Node head) {
        models.Node //3 vars
                curr = head,
                prev = null,
                nextNode;

        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    //    https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
    //    https://www.geeksforgeeks.org/reverse-a-linked-list-in-groups-of-given-size-iterative-approach/
    //    use recursive approach
    //    method: we first reverse all the k blocks, then point the head of every block to the new head(which is prev)
    models.Node reverseK(models.Node head) {
        models.Node
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
            head.next = reverseK(nextNode);//

        return prev;//
    }

    //    https://www.youtube.com/watch?v=PazsaUFz9io
    //    https://www.geeksforgeeks.org/flattening-a-linked-list/
    models.Node divide2D(models.Node head) {
        //base
        if (head == null)
            return null;

        if (head.right == null)
            return head;

        models.Node head2 = divide2D(head.right);

        return merge(head, head2);
    }

    models.Node clone(models.Node head1) {
        models.Node head2 = new models.Node(head1.data);
        models.Node temp = head2;
        head1 = head1.next;

        while (head1 != null) {
            temp.next = new models.Node(head1.data);
            temp = temp.next;
            head1 = head1.next;
        }
        return head2;
    }

    //    https://www.youtube.com/watch?v=EHpS2TBfWQg
    //    https://www.geeksforgeeks.org/clone-linked-list-next-random-pointer-o1-space/
    //    my implementation
    models.Node cloneHavingRandom(models.Node head) {
        models.Node head2 = clone(head);
        models.Node curr2 = head2;
        models.Node curr = head, nextNode = head;
        while (curr2 != null) {//curr2 or nextNode
            curr = nextNode;
            nextNode = curr.next;
            curr.next = curr2;
            curr2.random = curr;
            curr2 = curr2.next;
        }
        curr2 = head2;
        while (curr2 != null) {
            curr2.random = curr2.random.random.next;
            curr2 = curr2.next;
        }
        return head2;
    }

    //    https://www.geeksforgeeks.org/reverse-a-linked-list/
    models.Node recursiveReverse(models.Node curr, models.Node prev) {
        if (curr.next == null) {
            curr.next = prev;
            return curr;
        }

        models.Node nextNode = curr.next;

        curr.next = prev;

        head = recursiveReverse(nextNode, curr);
        return head;
    }

    //    https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
    //    Method 3(Using difference of node counts)
    models.Node intersect(models.Node n1, models.Node n2) {
        head1 = n1;
        head2 = n2;
        while (n1 != null) {
            n1 = n1.next;
            size1++;
        }
        while (n2 != null) {
            n2 = n2.next;
            size2++;
        }

        diff = Math.abs(size1, size2);

        if (size1 > size2) {
            for (int i = 0; i < diff; i++) {
                head1 = head1.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                head2 = head2.next;
            }
        }

        while (head1 != null) {//or while (head2 != null)
            if (head1 == head2)
                return head1;//or head2

            head1 = head1.next;
            head2 = head2.next;
        }
    }

    //    https://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/
    // this method changes the linkedLists
    models.Node intersect(models.Node head1, models.Node head2) {
        models.Node curr1 = head1, curr2 = head2;//good to copy head to newly created nodes

//      if not sorted, sort these linked lists using merge sort
        curr1 = divide(curr1);
        curr2 = divide(curr2);

        models.Node dummy = new models.Node(null);
        models.Node head = dummy;
        int prev = -1;

        while (curr1 != null && curr2 != null) {
            if (curr1.data == curr2.data) {
                if (curr1.data != prev) {
                    dummy.next = curr1;
                    prev = head1.data;
                }

                curr1 = curr1.next;
                curr2 = curr2.next;
            } else if (curr2.data < curr1.data) {
                dummy.next = curr2;
                curr2 = curr2.next;
            } else {
                dummy.next = curr1;
                curr1 = curr1.next;
            }

            dummy = dummy.next;
        }
        if (curr2 == null && curr1 != null)
            dummy.next = head1;
        if (curr1 == null && curr2 != null)
            dummy.next = curr2;

        return head.next;
    }

    //    //divide of merge sort
    //    //    3 Steps:
    //    //    1. Find mid
    //    //    2. Call this divide function again
    //    //    3. call merge function
    //    void divide(Integer l, Integer r) {
    //        if (l > r) {
    //            return;
    //        }
    //
    //        Integer mid = (l + r) / 2;
    //
    //        divide(l, mid);
    //        divide(mid + 1, r);
    //
    //        merge(l, mid, r);
    //    }
    models.Node divide(models.Node node) {
        if (node == null || node.next == null)
            return node;

        models.Node mid = getMiddleNode(node);

        models.Node mNext = mid.next;//store the 2nd half to pass it to divide fun //
        mid.next = null;//

        models.Node left = divide(node);
        models.Node right = divide(mNext);

        return merge(left, right);
    }

    //merge 2 sorted linked lists using dummy nodes
    //https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
    //https://www.geeksforgeeks.org/merge-two-sorted-lists-place/
    //Note: use dummy node for linked list merge sort for easy implementation
    models.Node merge(models.Node head1, models.Node head2) {
        models.Node curr1 = head1, curr2 = head2;//good to copy head to newly created nodes
        models.Node dummy = new models.Node(-1);
        models.Node head = dummy;

        while (curr1 != null && curr2 != null) {
            if (curr1.data < curr2.data) {
                dummy.next = curr1;
                curr1 = curr1.next;
            } else {
                dummy.next = curr2;
                curr2 = curr2.next;
            }
            dummy = dummy.next;
        }
        while (curr1 != null) {
            dummy.next = curr1;
            dummy = dummy.next;

            curr1 = curr1.next;
        }
        while (curr2 != null) {
            dummy.next = curr2;
            dummy = dummy.next;

            curr2 = curr2.next;
        }

        return head.next;
    }

    //    //with new memory allocated
    // https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
    models.Node merge(models.Node left, models.Node right) {
        //.
        //.
        //.

        if (curr1.data < curr2.data) {
            curr3.next = new models.Node(curr1.data);//just change these
            curr1 = curr1.next;
        }
    }

    models.Node getMiddleNode(models.Node node) {
        models.Node slowPtr = node, fastPtr = node;

        while (fastPtr.next != null && fastPtr.next.next != null) {//
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }

    //    https://www.geeksforgeeks.org/sum-of-two-linked-lists/
    //    https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
    //    reverse the list accordingly to achieve the logic
    models.Node sum(models.Node head1, models.Node head2) {
        models.Node prev = null;
        models.Node temp = null;
        models.Node result = null;
        models.Node curr1 = head1, curr2 = head2; //good to copy head to newly created nodes

        int carry = 0, sum;

        while (curr1 != null || curr2 != null) {
            sum = carry + (curr1 != null ? curr1.data : 0) + (curr2 != null ? curr2.data : 0);

            if (sum >= 10)
                carry = 1;
            else carry = 0;

            if (prev == null) {
                temp = new models.Node(sum % 10);
                prev = temp;
                result = prev;
            } else {
                temp = new models.Node(sum % 10);
                prev.next = temp;
            }

            prev = temp;

            if (curr1 != null)
                curr1 = curr1.next;
            if (curr2 != null)
                curr2 = curr2.next;
        }

        if (carry > 0) {
            temp = new models.Node(carry);
            prev.next = temp;
        }

        return result;
    }

    private void print(models.Node head) {
        models.Node curr = head;//copy head pointer to a reference

        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    //  inserts a new Node on the front of the list.
    private void push(int data) {
        models.Node node = new models.Node(data);

        node.next = head;
        head = node;
    }

    private void deleteNext(models.Node node) {
        node.next = node.next.next;
    }
}

public class Node {
    Integer data, h, d;
    models.Node left, right, next, random;

    Node(Integer data) {
        this.data = data;
        next = right = null;
        random = null;
    }
}
