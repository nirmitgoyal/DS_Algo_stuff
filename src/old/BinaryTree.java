package old;

import javafx.util.Pair;
import models.Node;

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
    //https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
    //https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-tree-set-2-using-parent-pointer/
    //see: https://www.youtube.com/watch?v=13m9ZCB8gjw
    static models.Node n1, n2;
    static private models.Node head = null;

    //    use: https://www.youtube.com/watch?v=suj1ro8TIVY
    //    https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/

    //    https://www.geeksforgeeks.org/connect-nodes-level-level-order-traversal/
    //    use level order traversal and mark prev.nextRight=currNode
    //https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-2/
    //https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-4/
    //https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
    //https://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
    static private models.Node prevNode = null;
    static private ArrayList<models.Node> path = new ArrayList<>();
    //    https://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/ //O(n)
    //    While traversing the tree recursively, keep track of the sum of every path in a var currSum. If you reach a leaf node, compare this currSum with a global maximum max.
    //    If currSum>max, then this is the leaf node we want and update max; Else do nothing.
    //    postorder and preoder are the most common traversal
    static private int maxSumFromRootToLeaf = 0;
    static private models.Node targetLeaf;
    //    https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
    static private Map<models.Node, Integer> inorderMap = new HashMap();
    static private Integer[] preorderInput = new Integer[10];
    //convert preorder array to queue
    static Queue<Integer> preorder = new LinkedList<>(Arrays.asList(preorderInput));
    static private int[] inorder = new int[10];
    models.Node root;
    //    https://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
    //    Approach: Append myself on the path and if I'm a leaf, then print the nodes at distance k from here
    int k;
    int path[];
    boolean visited[] = new boolean[n];
    //    Assume, that this node is in the path and add it in the path. Now 3 cases, 1st if the current node's data is same as the value, then return T. 2nd and 3rd, check if the path
    //    is there for left subtree and right subtree. If the path is there, return T. Else it means that the path is not there, now remove this node from the path and return F
    int inputValue;
    //    https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
    //    https://leetcode.com/problems/binary-tree-maximum-path-sum/
    //    see: https://www.youtube.com/watch?v=mOdetMWwtoI
    //    O(n)
    int maxPathSum = MIN_VALUE;
    //    https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
    //    https://www.youtube.com/watch?v=sa7p6jTW2FQ
    //    O(n)
    int maxPathSum = MIN_VALUE;
    // https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
    // https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/
    //height of a tree is maximum value of (leftSubTreeHeight + rightSubTreeHeight + 1) for each node.
    // see these setps:
    int maxDiameter;

    void kDistantFromLeaf(models.Node node, int i) {
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

        kDistantFromLeaf(node.L, i);
        kDistantFromLeaf(node.R, i);
    }

    void treeToDLL(models.Node node) {
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
    void vertical(models.Node node) {
        //

        Queue<Pair<models.Node, Integer>> q = new LinkedList<>();
        Map<Integer, ArrayList<models.Node>> m = new HashMap<>();

        q.add(new Pair<>(node, 0));
        m.put(0, new ArrayList<>(Arrays.asList(node)));

        while (!q.isEmpty()) {
            Pair<models.Node, Integer> currPair = q.poll();
            models.Node currNode = currPair.getKey();
            int dist = currPair.getValue();

            if (currNode.L != null) {
                int distLeft = dist - 1;
                q.add(new Pair<>(currNode.L, distLeft));

                if (m.containsKey(distLeft)) {
                    m.get(distLeft).add(currNode.L);
                } else {
                    m.put(distLeft, new ArrayList<>(Arrays.asList(currNode.L)));
                }
            }
            if (currNode.R != null) {
                int distRight = dist + 1;
                q.add(new Pair<>(currNode.R, distRight));

                if (m.containsKey(distRight)) {
                    m.get(distRight).add(currNode.R);
                } else {
                    m.put(distRight, new ArrayList<>(Arrays.asList(currNode.R)));
                }
            }
        }
    }

    // https://www.geeksforgeeks.org/reverse-level-order-traversal/
    // take a Q and a stack
    // 1) Instead of printing a node, push the node to stack
    // 2) R->L
    void reverseLevelOrder(models.Node node) {
        Stack<models.Node> S = new Stack<>();
        Queue<models.Node> Q = new LinkedList<>();
        Q.add(node);

        while (!Q.isEmpty()) {
            models.Node currNode = Q.poll();
            S.push(currNode);

            if (currNode.R != null)
                Q.add(currNode.R);

            if (currNode.L != null)
                Q.add(currNode.L);
        }

        while (!S.empty()) {
            System.out.print(S.pop() + " ");
        }
    }

    //    https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
    //    use method: Take 2 stacks and alternatively fill those stacks, depending on situation given. One stack is to be pushed R->L another L->R
    void spiral(models.Node node) {
        //

        Stack<models.Node> sPushRL = new Stack<>();
        Stack<models.Node> sPushLR = new Stack<>();

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
                    models.Node currNode = sPushLR.pop();
                    System.out.println(currNode);

                    if (currNode.R != null) {
                        sPushRL.push(currNode.R);
                    }
                    if (currNode.L != null) {
                        sPushRL.push(currNode.L);
                    }

                    c2--;
                }
            } else {
                while (c1 > 0) {
                    models.Node currNode = sPushRL.pop();
                    System.out.println(currNode);

                    if (currNode.L != null) {
                        sPushLR.push(currNode.L);
                    }
                    if (currNode.R != null) {
                        sPushLR.push(currNode.R);
                    }

                    c1--;
                }
            }

            level++;
        }
    }

    private models.Node LCABTree(models.Node node) {
        if (node == null)
            return null;

        if (node == n1 || node == n2)//1
            return node;

        models.Node leftSearchResult = LCA(node.L);//2
        models.Node rightSearchResult = LCA(node.R);//3

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
    models.Node lcaBST(models.Node node) {
        if (node == null)
            return null;

        if ((n1.data <= node.data && n2.data >= node.data) || (n1.data >= node.data && n2.data <= node.data))
            return node;

        if (n1.data < node.data
                && n2.data < node.data)
            return lcaBST(node.L);
        else
            return lcaBST(node.R);
    }

    boolean isThereAPathBetweenANodeAndAValueAlsoCreateThatPath(models.Node node) {
        //

        path.add(node);

        //3 cases
        if ((node.data == inputValue)
                || (node.L != null && isThereAPathBetweenANodeAndAValueAlsoCreateThatPath(node.L))
                || (node.R != null && isThereAPathBetweenANodeAndAValueAlsoCreateThatPath(node.R))) {
            return true;
        } else {// If not present in subtree rooted with node, remove node.data from path and return false
            path.remove(path.size() - 1);
            return false;
        }
    }

    void maxSumFromRootToLeaf(models.Node node, int currSum) {
        if (node == null) return;

        currSum += node.data;

        //if leaf
        if (isLeaf(node)) {
            if (currSum > maxSumFromRootToLeaf) {
                maxSumFromRootToLeaf = currSum;
                targetLeaf = node;
            }
        }

        maxSumFromRootToLeaf(node.L, currSum);
        maxSumFromRootToLeaf(node.R, currSum);
    }

    int maxGain(models.Node node) {
        if (node == null) return 0;

        int maxGainFromLeft = max(maxGain(node.L), 0);
        int maxGainFromRight = max(maxGain(node.R), 0);

        maxPathSum = max(maxPathSum, (maxGainFromLeft + maxGainFromRight + node.data));

        return (max(maxGainFromLeft, maxGainFromRight) + node.data);
    }

    int maxGainWithLeaves(models.Node node) {
        if (node == null) return 0;

        if (isLeaf(node))
            return node.data;
        int maxGainFromLeft = maxGainWithLeaves(node.L);
        int maxGainFromRight = maxGainWithLeaves(node.R);
        //we cannot combine the below statements
        if (node.L != null && node.R != null) {
            maxPathSum = max(maxPathSum, maxGainFromLeft + maxGainFromRight + node.data);//this statement is just present here only, as we need a node with 2 childs to have 2 leaf nodes
            return max(maxGainFromLeft, maxGainFromRight) + node.data;
        }
        if (node.L != null)
            return maxGainFromRight + node.data;
        if (node.R != null)
            return maxGainFromLeft + node.data;
    }

    models.Node treeFromInorderAndPostorder(int inorderStartIndex, int inorderEndIndex) {
        if (preorder.isEmpty() || (inorderStartIndex > inorderEndIndex))//5
            return null;

        models.Node node = new models.Node(preorder.poll());//1

        int inorderIndex = indexOf(node);
        node.L = treeFromInorderAndPostorder(inorderStartIndex, inorderIndex - 1);//2
        node.R = treeFromInorderAndPostorder(inorderIndex + 1, inorderEndIndex);//3

        return node;//4
    }

    private int indexOf(models.Node node) {
        return inorderMap.get(node);
    }

    void LOT() {
        Queue<models.Node> queue = new LinkedList<models.Node>();

        queue.add(root);

        while (!queue.isEmpty()) {
            models.Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.L != null) {
                queue.add(tempNode.L);
            }

            if (tempNode.R != null) {
                queue.add(tempNode.R);
            }
        }
    }

    void printBoundary(models.Node node) {
        System.out.println("anti clockwise Boundary Traversal of binary tree");
        if (node == null)
            return;
        System.out.println(node.data);
        printLeftBoundary(node.L);

        printLeaves(node);

        printRightBoundary(node.R);
    }

    //    https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
    private boolean isBalanced(models.Node node, Height height) {
        /* If tree is empty then return true */
        if (node == null) {
            height.height = 0;
            return true;
        }

        /* Get heights of left and right sub trees */
        Height lheixght = new Height(), rheight = new Height();
        boolean l = isBalanced(node.L, lheight);
        boolean r = isBalanced(node.R, rheight);
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
    //    iterative traversal of tree
    Integer heightIterative(models.Node root) {
        if (root == null)
            return 0;

        Queue<models.Node> q = new LinkedList<>();
        q.add(root);

        Integer height = 0;

        while (true) {
            int count = q.size();
            if (count == 0)
                break;

            //every level
            height++;
            while (count > 0) {
                models.Node node = q.poll();

                if (node.L != null)
                    q.add(node.L);
                if (node.R != null)
                    q.add(node.R);

                count--;
            }
        }

        return height;
    }

    //    Height is the number of nodes along the longest path from the root node down to the farthest leaf node = (max(leftH, rightH) + 1)
    //    https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
    Integer height(models.Node node) {
        if (node == null)
            return 0;

        int leftH = height(node.L);
        int rightH = height(node.R);

        return (max(leftH, rightH) + 1);
    }

    models.Node diameter1(models.Node node) {
        if (node == null)
            return new models.Node(null, null, 0, 0);

        models.Node leftNode = diameter1(node.L);
        models.Node rightNode = diameter1(node.R);


        node.h = max(leftNode.h, rightNode.h) + 1;
        node.d = max(leftNode.d, rightNode.d, (1 + leftNode.h + rightNode.h));

        maxDiameter = max(maxDiameter, node.d);

        return node;
    }

    int height(models.Node node) {
        if (node == null)
            return 0;

        int leftH = height(node.L);
        int rightH = height(node.R);

        maxDiameter = max(maxDiameter, leftH + rightH + 1);//

        int h = max(leftH, rightH) + 1;

        return h;
    }

    //    https://www.youtube.com/watch?v=wGXB9OWhPTg
    //    Inorder Tree Traversal without recursion and without stack! || morris traversal
    void inorder(models.Node root) {
        models.Node current = root;

        while (current != null) {
            //left is null then print the node and go to right
            if (current.L == null) {
                System.out.print(current.data + " ");
                current = current.R;
            } else {
                //find the predecessor.
                models.Node predecessor = current.L;
                //To find predecessor keep going right till right node is not null or right node is not current.
                while (predecessor.R != current && predecessor.R != null)
                    predecessor = predecessor.R;
                //if right node is null then go left after establishing link from predecessor to current.
                if (predecessor.R == null) {
                    predecessor.R = current;
                    current = current.L;//(LEFT)
                } else { //left is already visit. Go rigth after visiting current.
                    predecessor.R = null;
                    System.out.print(current.data + " ");//(ROOT)
                    current = current.R;//(RIGHT)
                }
            }
        }
    }

    private boolean isLeaf(Node node) {
        return (node.L == null && node.R == null);
    }
}

class Height {
    int height = 0;
}




