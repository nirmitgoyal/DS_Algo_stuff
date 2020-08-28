package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static java.lang.Integer.MAX_VALUE;

//    https://www.geeksforgeeks.org/given-array-strings-find-strings-can-chained-form-circle/
//    use: https://www.geeksforgeeks.org/find-array-strings-can-chained-form-circle-set-2/

//    https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
//    https://leetcode.com/problems/verifying-an-alien-dictionary/
//    use: https://www.youtube.com/watch?v=RPpnRavqb8g

public class Graph {

    private static boolean[] visited = new boolean[1000];//
    private static ArrayList<ArrayList<Integer>> g = new ArrayList<>();//adjacencyList
    //topological sort implementation is DFS but just contains an extra arraylist to store the order
    private static ArrayList<Integer> a = new ArrayList<>();
    //    https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
    //    https://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/
    //    https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
    //    2 methods:
    //    1. If DFS has a back egde(just see the method, but prefer using 2nd method)
    //    2. While doing DFS, if we encounter an edge from current node to a GRAY node, then this edge is back edge and hence there is a cycle.(prefer)
    //    no need of visited array
    private static String[] bucket = new String[1000];
    //    https://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
    //    exponential  time complexity
    //    use DFS
    ArrayList<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        //topological sort
        Integer vertices = 6;
        addEdge(5, 2);//or graph.get(5).add(2);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // is important for directed graph
        for (int i = 0; i < vertices; i++)
            if (!visited[i])
                BFS(i);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // is important for directed graph
        for (int i = 0; i < vertices; i++)
            if (!visited[i])
                DFS(i);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < vertices; i++)
            if (!visited[i])
                topologicalSort(i);

        //print
        System.out.println(a);//or in reverse order
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // is important for directed graph
        for (int i = 0; i < vertices; i++)
            if (!visited[i])
                if (isCyclePresentDirected(i))
                    return true;

    }

    //    https://stackoverflow.com/a/26551061
    //    https://www.quora.com/What-is-the-time-complexity-of-Breadth-First-Search-Traversal-of-a-graph
    static void BFS(int node) {//here node is of primitive type
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            Integer currNode = queue.poll();
            System.out.println(currNode);

            //fetch all it's connected nodes
            ArrayList<Integer> connectedNodes = g.get(currNode);
            //iterate over them and add to q, if not visited
            for (int i = 0; i < connectedNodes.size(); i++) {
                int connectedNode = connectedNodes.get(i);

                if (!visited[connectedNode]) {
                    queue.add(connectedNode);
                    visited[connectedNode] = true;
                }
            }
        }
    }

    static void topologicalSort(Integer node) {
        // Mark the current node as visited
        visited[node] = true;

        // Recur for all the nodes adjacent to this node
        ArrayList<Integer> connectedNodes = g.get(node);
        for (int i = 0; i < connectedNodes.size(); i++) {
            Integer currNode = connectedNodes.get(i);
            if (!visited[currNode])
                topologicalSort(currNode);
        }

        a.add(node);
    }

    static Boolean isCyclePresentDirected(int node) {
        bucket[node] = "gray";

        ArrayList<Integer> connectedNodes = g.get(node);
        for (int i = 0; i < connectedNodes.size(); i++) {
            int currNode = connectedNodes.get(i);

            if (bucket[currNode] == "gray" || (bucket[currNode] == "white" && isCyclePresentDirected(currNode))) {
                return true;
            }
        }

        bucket[node] = "black";

        return false;
    }

    private static void addEdge(Integer source, Integer dest) {
        g.get(source).add(dest);//get returned a linkedList, and then we added an element in the linkedlist
    }

    //    https://www.quora.com/Why-is-the-complexity-of-DFS-O-V+E
    void DFS(int node) {
        // Mark the current node as visited and print it
        visited[node] = true;
        System.out.print(node);

        // Recur for all the nodes adjacent to this node
        ArrayList<Integer> connectedNodes = g.get(node);
        for (int i = 0; i < connectedNodes.size(); i++) {
            int currNode = connectedNodes.get(i);

            if (!visited[currNode]) {
                DFS(currNode);
            }
        }
    }

    //usign adjacency matrix
    void DFS(int i) {
        System.out.println(i);
        visited[i] = true;

        for (int j = 0; j < n; j++)
            if (!visited[j] && G[i][j] != 0)
                DFS(j);
    }

    //difference from directed function: pass parent node as well so that when you compare gray adjacent nodes you have to make sure the adjacent gray node is not the parent that u just visited
    Boolean isCyclePresentUndirected(int node, int parentNode) {
        bucket[node] = "gray";

        ArrayList<Integer> connectedNodes = g.get(node);
        for (int i = 0; i < connectedNodes.size(); i++) {
            int currNode = connectedNodes.get(i);

            if ((bucket[currNode] == "gray" && currNode != parentNode) || (bucket[currNode] == "white" && isCyclePresentUndirected(currNode, node)))
                return true;
        }

        bucket[node] = "black";

        return false;
    }

    //build graph earlier using buildGraph() - a function
    int minCostPath(Node node) {
        int min = MAX_VALUE;
//        Use a LinkedHashMap to keep the order intact.
        Map<String, Node> map = new LinkedHashMap<>();//"row"+"-"+"col"
        map.put(String.valueOf(node.row) + "-" + String.valueOf(node.col), node);

        while (!map.isEmpty()) {
            Entry entry = map.nodeSet().iterator().next();

            Node currNode = entry.getValue();

            map.remove(entry.getKey());

            ArrayList<Node> connectedNodes = g.get(currNode);
            for (int i = 0; i < connectedNodes.size(); i++) {
                Node connectedNode = connectedNodes.get(i);

                final int newDist = currNode.dist + connectedNode.value;

                if (newDist < connectedNode.dist) {
                    map.put(connectedNode.row + "-" + connectedNode.col, new Node(connectedNode.row, connectedNode.col, connectedNode.value, newDist));
                    if (isDestination()) {
                        min = Integer.min(min, newDist);
                    }
                }
            }
        }

        return min;
    }

    int minTime(int[][] original) {
        Node a[][] = new Node[rows][cols];

        //1. create new matrix
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                a[row][col] = new Node(row, col, original[row][col], 0);
            }
        }

        //2. bfs
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (a[row][col].type == 2) {
                    q.add(a[row][col]);
                }
            }
        }

        while (!q.isEmpty()) {
            Node currNode = q.poll();

            for (int k = 0; k < 4; k++) {
                int newRow = currNode.row + x[k];
                int newCol = currNode.col + y[k];

                if (isSafe(newRow, newCol) && currNode.type == 1) {
                    a[newRow][newCol].type = 2;
                    a[newRow][newCol].time = currNode.time + 1;

                    q.add(a[newRow][newCol]);
                }
            }
        }

        //3. calculate ans
        return calculateAns();
    }

    int minTimeComplex() {
        buildGraph();
        return bfs(0);
    }

    void buildGraph() {
        int index = 0;
        Graph g = new Graph(vertices);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (cell == 1) {
                    Node node = new Node(index++, a[row][col], MAX_VALUE);
                }
                if (cell == 2) {
                    Node node = new Node(index++, a[row][col], 0);
                }

                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        int cell = a[x[row + i]][y[col + j]];
                        if (cell == 1) {
                            g.addEdge(node, new Node())
                        }
                    }
                }
            }
        }
    }

    void DFS(int node) {
        path.add(node);

        if (node == dest)
            System.out.println(path);

        // Recur for all the nodes adjacent to this node
        ArrayList<Integer> connectedNodes = g.get(node);
        for (int i = 0; i < connectedNodes.size(); i++) {
            int currNode = connectedNodes.get(i);
            DFS(currNode);
            path.remove(path.size() - 1);
        }
    }

    private boolean isDestination() {
        return false;
    }

    //    https://www.geeksforgeeks.org/min-cost-path-dp-6/
    //    https://www.geeksforgeeks.org/minimum-cost-path-left-right-bottom-moves-allowed///
    //    use: BFS for every such problem
    class Node {
        int row, col;
        int value;
        int dist;

        public Node(int row, int col, int value, int dist) {
            //
        }
    }

    //    https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
    //    use this method: https://leetcode.com/articles/rotting-oranges/ (personalized code below)
    //    using my below method will take a lot of time and becomes very complex due to an additional member 'type'
    class Node {
        int row, col, type, time;
    }
}