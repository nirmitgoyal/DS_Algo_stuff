import models.Node;

import java.util.Stack;

public class SortedArrayToBST {

    Node sortedArrayToBST(int[] a) {
        return sortedArrayToBSTHelper(0, a.length - 1, a);
    }

    private Node sortedArrayToBSTHelper(int start, int end, int[] a) {
        if (a == null || a.length == 0 || start > end)
            return null;

        int mid = (start + end) / 2;
        Node node = new Node(a[mid]);

        if (mid != 0)
            node.L = sortedArrayToBSTHelper(start, mid - 1, a);
        if (mid != a.length - 1)
            node.R = sortedArrayToBSTHelper(mid + 1, end, a);

        return node;
    }

    //iterative:
    Node sortedArrayToBSTIterative(int[] a) {
        int n = a.length;

        if (n == 0)
            return null;

        Stack<Element> stack = new Stack<>();
        Node root = new Node(null);
        stack.push(new Element(0, n - 1, root));

        while (!stack.isEmpty()) {
            Element e = stack.pop();
            Node parent = e.node;

            if (e.start < e.end) {
                int mid = (e.start + e.end) / 2;
                parent.data = 0;

                if (mid != 0) {
                    parent.L = new Node(null);
                    stack.push(new Element(e.start, mid - 1, parent.L));
                }
                if (mid != n - 1) {
                    parent.R = new Node(null);
                    stack.push(new Element(mid + 1, e.end, parent.R));
                }
            }
        }

        return root;
    }

    static class Element {
        int start, end;
        Node node;

        public Element(int start, int end, Node node) {
        }
    }
}
