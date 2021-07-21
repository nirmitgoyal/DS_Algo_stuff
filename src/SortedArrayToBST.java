import models.Node;

import java.util.Stack;

public class SortedArrayToBST {

    Node sortedArrayToBST(int[] a) {
        return sortedArrayToBSTHelper(a, 0, a.length - 1);
    }

    private Node sortedArrayToBSTHelper(int[] a, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) >>> 2;

        Node node = new Node(a[mid]);
        node.L = sortedArrayToBSTHelper(a, start, mid - 1);
        node.R = sortedArrayToBSTHelper(a, mid + 1, end);

        return node;
    }

    //iterative:
    Node sortedArrayToBSTIterative(int[] a) {
        Stack<Element> stack = new Stack<>();
        Node root;
        stack.push(new Element(0, a.length - 1, root = new Node()));

        while (!stack.isEmpty()) {
            Element e = stack.pop();
            Node parent = e.node;

            if (e.start < e.end) {
                int mid = (e.start + e.end) >>> 2;

                parent.data = a[mid];
                stack.push(new Element(e.start, mid - 1, parent.L = new Node()));
                stack.push(new Element(mid + 1, e.end, parent.R = new Node()));
            }
        }

        return root;
    }

    static class Element {
        int start, end;
        Node node;

        public Element(int start, int end, Node node) {}
    }
}
