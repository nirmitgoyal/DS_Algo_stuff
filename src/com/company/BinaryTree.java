package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;

class BinaryTree {
    Node root;
    static private Node head = null;

    //    use: https://www.youtube.com/watch?v=suj1ro8TIVY
    //    https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/

    //    https://www.geeksforgeeks.org/connect-nodes-level-level-order-traversal/
    //    use level order traversal and mark prev.nextRight=currNode


    //    https://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
    //    Approach: Append myself on the path and if I'm a leaf, then print the nodes at distance k from here
    int k;
    int path[];
    boolean visited[]=new boolean[n];

    void kDistantFromLeaf(Node node, int i) {
        //

//      append myself to the path array
        path[i] = node.data;
        i++;

//      and if i am a leaf(and i was not printed), i know my ansectors at distance k
        int index = i - k - 1;
        if (isLeaf(node) && isIndexSafe(index) && !visited[index]) {
            System.out.print(path[index]);
            visited[index] = true;
            return;
        }

        kDistantFromLeaf(node.left, i);
        kDistantFromLeaf(node.right, i);
    }

    //https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-2/
    //https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-4/
    //https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
    //https://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
    static private Node prevNode = null;

    void treeToDLL(Node node) {
        //

        //recurse left subtree

        if (prevNode == null) {//3
            head = node;
        } else {//1
            prevNode.next = node;//
            node.prev = prevNode;//
        }

        prevNode = node;//2

        //recurse right subtree
    }

    //    Use:  https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
    //    https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
    //    https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
    void vertical(Node node) {
        //

        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        Map<Integer, ArrayList<Node>> m = new HashMap<>();

        q.add(new Pair<>(node, 0));
        m.put(0, new ArrayList<>(Arrays.asList(node)));

        while (!q.isEmpty()) {
            Pair<Node, Integer> currPair = q.poll();
            Node currNode = currPair.getKey();
            int dist = currPair.getValue();

            if (currNode.left != null) {
                int distLeft = dist - 1;
                q.add(new Pair<>(currNode.left, distLeft));

                if (m.containsKey(distLeft)) {
                    m.get(distLeft).add(currNode.left);
                } else {
                    m.put(distLeft, new ArrayList<>(Arrays.asList(currNode.left)));
                }
            }
            if (currNode.right != null) {
                int distRight = dist + 1;
                q.add(new Pair<>(currNode.right, distRight));

                if (m.containsKey(distRight)) {
                    m.get(distRight).add(currNode.right);
                } else {
                    m.put(distRight, new ArrayList<>(Arrays.asList(currNode.right)));
                }
            }
        }
    }

    // https://www.geeksforgeeks.org/reverse-level-order-traversal/
    // take a Q and a stack
    // 1) Instead of printing a node, push the node to stack
    // 2) R->L
    void reverseLevelOrder(Node node) {
        Stack<Node> S = new Stack<>();
        Queue<Node> Q = new LinkedList<>();
        Q.add(node);

        while (!Q.isEmpty()) {
            Node currNode = Q.poll();
            S.push(currNode);

            if (currNode.right != null)
                Q.add(currNode.right);

            if (currNode.left != null)
                Q.add(currNode.left);
        }

        while (!S.empty()) {
            System.out.print(S.pop() + " ");
        }
    }

    //    https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
    //    use method: Take 2 stacks and alternatively fill those stacks, depending on situation given. One stack is to be pushed R->L another L->R
    void spiral(Node node) {
        //

        Stack<Node> sPushRL = new Stack<>();
        Stack<Node> sPushLR = new Stack<>();

        sPushRL.add(node);
        int level = 1, c1 = 0, c2 = 0;

        while (true) {
            if (isEven(level))
                c2 = sPushLR.size();
            else
                c1 = sPushRL.size();

            if (isEven(level)) {
                if (c2 == 0)
                    break;
            } else {
                if (c1 == 0)
                    break;
            }

//          on every level
            if (isEven(level)) {
                while (c2 > 0) {
                    Node currNode = sPushLR.pop();
                    System.out.println(currNode);

                    if (currNode.right != null) {
                        sPushRL.push(currNode.right);
                    }
                    if (currNode.left != null) {
                        sPushRL.push(currNode.left);
                    }

                    c2--;
                }
            } else {
                while (c1 > 0) {
                    Node currNode = sPushRL.pop();
                    System.out.println(currNode);

                    if (currNode.left != null) {
                        sPushLR.push(currNode.left);
                    }
                    if (currNode.right != null) {
                        sPushLR.push(currNode.right);
                    }

                    c1--;
                }
            }

            level++;
        }
    }

    //https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
    //https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-tree-set-2-using-parent-pointer/
    //see: https://www.youtube.com/watch?v=13m9ZCB8gjw
    static Node n1, n2;

    private Node LCABTree(Node node) {
        if (node == null)
            return null;

        if (node == n1 || node == n2)//1
            return node;

        Node leftSearchResult = LCA(node.left);//2
        Node rightSearchResult = LCA(node.right);//3

        //4
        if (leftSearchResult == null && rightSearchResult == null)
            return null;
        else if (leftSearchResult != null && rightSearchResult != null)
            return node;
        else if (leftSearchResult != null)
            return leftSearchResult;
        else
            return rightSearchResult;
    }

    //    LCA BST
    //    https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
    //    see: https://www.youtube.com/watch?v=TIoCCStdiFo
    //    this code works; tested on gfg
    Node lcaBST(Node node) {
        if (node == null)
            return null;

        if ((n1.data <=node.data && n2.data >= node.data) || (n1.data >= node.data && n2.data <= node.data))
            return node;

        if (n1.data < node.data && n2.data < node.data)
            return lcaBST(node.left);
        else
            return lcaBST(node.right);
    }

    //    Assume, that this node is in the path and add it in the path. Now 3 cases, 1st if the current node's data is same as the value, then return T. 2nd and 3rd, check if the path
    //    is there for left subtree and right subtree. If the path is there, return T. Else it means that the path is not there, now remove this node from the path and return F
    int inputValue;
    static private ArrayList<Node> path = new ArrayList<>();

    boolean isThereAPathBetweenANodeAndAValueAlsoCreateThatPath(Node node) {
        //

        path.add(node);

        //3 cases
        if ((node.data == inputValue)
                || (node.left != null && isThereAPathBetweenANodeAndAValueAlsoCreateThatPath(node.left))
                || (node.right != null && isThereAPathBetweenANodeAndAValueAlsoCreateThatPath(node.right))) {
            return true;
        } else {// If not present in subtree rooted with node, remove node.data from path and return false
            path.remove(path.size() - 1);
            return false;
        }
    }

    //    https://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/ //O(n)
    //    While traversing the tree recursively, keep track of the sum of every path in a var currSum. If you reach a leaf node, compare this currSum with a global maximum max.
    //    If currSum>max, then this is the leaf node we want and update max; Else do nothing.
    //    postorder and preoder are the most common traversal
    static private int maxSumFromRootToLeaf = 0;
    static private Node targetLeaf;

    void maxSumFromRootToLeaf(Node node, int currSum) {
        if (node == null) return;

        currSum += node.data;

        //if leaf
        if (isLeaf(node)) {
            if (currSum > maxSumFromRootToLeaf) {
                maxSumFromRootToLeaf = currSum;
                targetLeaf = node;
            }
        }

        maxSumFromRootToLeaf(node.left, currSum);
        maxSumFromRootToLeaf(node.right, currSum);
    }

    //    https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
    //    https://leetcode.com/problems/binary-tree-maximum-path-sum/
    //    see: https://www.youtube.com/watch?v=mOdetMWwtoI
    //    O(n)
    int maxPathSum = MIN_VALUE;

    int maxGain(Node node) {
        if (node == null) return 0;

        int maxGainFromLeft = max(maxGain(node.left), 0);
        int maxGainFromRight = max(maxGain(node.right), 0);

        maxPathSum = max(maxPathSum, (maxGainFromLeft + maxGainFromRight + node.data));

        return (max(maxGainFromLeft, maxGainFromRight) + node.data);
    }

    //    https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
    //    https://www.youtube.com/watch?v=sa7p6jTW2FQ
    //    O(n)
    int maxPathSum = MIN_VALUE;

    int maxGainWithLeaves(Node node) {
        if (node == null) return 0;

        if (isLeaf(node))
            return node.data;
        int maxGainFromLeft = maxGainWithLeaves(node.left);
        int maxGainFromRight = maxGainWithLeaves(node.right);
        //we cannot combine the below statements
        if (node.left != null && node.right != null) {
            maxPathSum = max(maxPathSum, maxGainFromLeft + maxGainFromRight + node.data);//this statement is just present here only, as we need a node with 2 childs to have 2 leaf nodes
            return max(maxGainFromLeft, maxGainFromRight) + node.data;
        }
        if (node.left != null)
            return maxGainFromRight + node.data;
        if (node.right != null)
            return maxGainFromLeft + node.data;
    }

    //    https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
    static private Map<Node, Integer> inorderMap = new HashMap();
    static private Integer[] preorderInput = new Integer[10];
    static private int[] inorder = new int[10];
    //convert preorder array to queue
    static Queue<Integer> preorder = new LinkedList<>(Arrays.asList(preorderInput));

    Node treeFromInorderAndPostorder(int inorderStartIndex, int inorderEndIndex) {
        if (preorder.isEmpty() || (inorderStartIndex > inorderEndIndex))//5
            return null;

        Node node = new Node(preorder.poll());//1

        int inorderIndex = indexOf(node);
        node.left = treeFromInorderAndPostorder(inorderStartIndex, inorderIndex - 1);//2
        node.right = treeFromInorderAndPostorder(inorderIndex + 1, inorderEndIndex);//3

        return node;//4
    }

    private int indexOf(Node node) {
        return inorderMap.get(node);
    }

    void LOT() {
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    void printBoundary(Node node) {
        System.out.println("anti clockwise Boundary Traversal of binary tree");
        if (node == null)
            return;
        System.out.println(node.data);
        printLeftBoundary(node.left);

        printLeaves(node);

        printRightBoundary(node.right);
    }


    //    https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
    private boolean isBalanced(Node node, Height height) {
        /* If tree is empty then return true */
        if (node == null) {
            height.height = 0;
            return true;
        }

        /* Get heights of left and right sub trees */
        Height lheixght = new Height(), rheight = new Height();
        boolean l = isBalanced(node.left, lheight);
        boolean r = isBalanced(node.right, rheight);
        int lh = lheight.height, rh = rheight.height;

        /* Height of current node is max of heights of
           left and right subtrees plus 1*/
        height.height = max(lh, rh) + 1;

        /* If difference between heights of left and right
           subtrees is more than 2 then this node is not balanced
           so return 0 */
        if (l && r && Math.abs(lh - rh) <= 1)
            return true;
        return false;

        /* If this node is balanced and left and right subtrees
           are balanced then return true */
    }

    //    https://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/   another iterative method
    //    iterative traversal of trtee
    Integer heightIterative(Node root) {
        if (root == null)
            return 0;

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        Integer height = 0;

        while (true) {
            int count = q.size();
            if (count == 0)
                break;

            //every level
            height++;
            while (count > 0) {
                Node node = q.poll();

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);

                count--;
            }
        }

        return height;
    }

    //    Height is the number of nodes along the longest path from the root node down to the farthest leaf node = (max(leftH, rightH) + 1)
    //    https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
    Integer height(Node node) {
        if (node == null)
            return 0;

        int leftH = height(node.left);
        int rightH = height(node.right);

        return (max(leftH, rightH) + 1);
    }

    // https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
    // https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/
    //height of a tree is maximum value of (leftSubTreeHeight + rightSubTreeHeight + 1) for each node.
    // see these setps:
    int maxDiameter;

    Node diameter1(Node node) {
        if (node == null)
            return new Node(null, null, 0, 0);

        Node leftNode = diameter1(node.left);
        Node rightNode = diameter1(node.right);


        node.h = max(leftNode.h, rightNode.h) + 1;
        node.d = max(leftNode.d, rightNode.d, (1 + leftNode.h + rightNode.h));

        maxDiameter = max(maxDiameter, node.d);

        return node;
    }

    int height(Node node) {
        if (node == null)
            return 0;

        int leftH = height(node.left);
        int rightH = height(node.right);

        maxDiameter = max(maxDiameter, leftH + rightH + 1);//

        int h = max(leftH, rightH) + 1;

        return h;
    }

    //    https://www.youtube.com/watch?v=wGXB9OWhPTg
    //    Inorder Tree Traversal without recursion and without stack! || morris traversal
    void inorder(Node root) {
        Node current = root;

        while (current != null) {
            //left is null then print the node and go to right
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                //find the predecessor.
                Node predecessor = current.left;
                //To find predecessor keep going right till right node is not null or right node is not current.
                while (predecessor.right != current && predecessor.right != null)
                    predecessor = predecessor.right;
                //if right node is null then go left after establishing link from predecessor to current.
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;//(LEFT)
                } else { //left is already visit. Go rigth after visiting current.
                    predecessor.right = null;
                    System.out.print(current.data + " ");//(ROOT)
                    current = current.right;//(RIGHT)
                }
            }
        }
    }

    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
}

public class Node {
    public Integer data;
    public Node left, right, nextRight, prev, next;

    public Node(Integer item) {
        data = item;
        left = right = nextRight = null;
    }
}

class Height {
    int height = 0;
}




