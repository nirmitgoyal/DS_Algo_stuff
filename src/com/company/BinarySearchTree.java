package com.company;

public class BinarySearchTree {
    //use: https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
    //https://www.geeksforgeeks.org/two-nodes-of-a-bst-are-swapped-correct-the-bst-set-2/
    //https://www.geeksforgeeks.org/sort-an-almost-sorted-array-where-only-two-elements-are-swapped/
    //no auxilarry space
    Node node1, node2, node3, prev = null;

    void correctBST(Node root) {
        //

        findCorrupts(root);

        if (node2 ==null){
            swap(node1, node3);
        }else {
            swap(node1, node2);
        }
    }

    private void findCorrupts(Node node) {//perform inorder traversal
        //

        findCorrupts(node.left);

        if (prev != null && node.data < prev.data) {
            if (node2 == null) {
                node1 = prev;
                node2 = node;
            } else {
                node2 = null;
                node3 = node;
            }
        }

        prev = node;

        findCorrupts(node.right);
    }
    private void swap(Node node1, Node node2) {
        int temp=node1.data;
        node1.data=node2.data;
        node2.data=temp;
    }

    //    https://www.geeksforgeeks.org/find-pairs-with-given-sum-such-that-pair-elements-lie-in-different-bsts/
    //    https://www.geeksforgeeks.org/count-pairs-from-two-bsts-whose-sum-is-equal-to-a-given-value-x/
    //    use: https://www.youtube.com/watch?v=D1Tv5cCs1d8

    //    https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
    //    https://www.youtube.com/watch?v=yEwSGhSsT0U&vl=en
    //    wrong:
    boolean wrongIsBST(models.Node node) {
        if (node == null)
            return true;

        boolean case1 = true, case2 = true;

        if (node.left != null) {
            if (node.data > node.left.data)
                case1 = true;
            else case1 = false;
        }
        if (node.right != null) {
            if (node.data < node.right.data)
                case2 = true;
            else case2 = false;
        }
        return case1 && case2 && wrongIsBST(node.left) && wrongIsBST(node.right);
    }

    //    right:
    //    O(n^2)
    boolean isBST(models.Node node) {
        if (node == null)
            return true;

        return areAllNodesLesser(node.left, node.data) && areAllNodesGreater(node.right, node.data)
                && isBST(node.left) && isBST(node.right);
    }

    //O(n)
    Boolean isBST(models.Node node, Integer minBound, Integer maxBound) {
        //base
        if (node == null)
            return true;

        return node.data > minBound && node.data <= maxBound
                && isBST(node.left, minBound, node.data) && isBST(node.right, node.data, maxBound);
    }

    Node insert(Node node, Integer value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value > node.data)
            node.right = insert(node.right, value);
        else
            node.left = insert(node.left, value);
        return node;
    }

    private Node search(Node node, Integer value) {
        if (node == null || node.data.equals(value))
            return node;
        if (value > node.data)
            return search(node.right, value);
        else return search(node.left, value);
    }

    class Node {
        Integer data;
        Node left, right;

        Node(Integer data) {
            this.data = data;
            left = right = null;
        }
    }
}