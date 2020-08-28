import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class isCyclePresent {
    static ArrayList<ArrayList<Integer>> g;

    static Map<Integer, Boolean> visited = new HashMap<>();
    static Map<Integer, Boolean> cache = new HashMap<>();

    //O(n)
    boolean isCyclePresent(int[] nodes) {
        for (int i = 0; i < n; i++) {
            if (DFS(i))
                return true;
        }
        return false;
    }

    boolean DFS(int node) {
        if (cache.containsKey(node))
            return cache.get(node);

        if (visited.containsKey(node) && visited.get(node))
            return true;
        visited.put(node, true);

        boolean hasCycle = false;
        for (int currNode : getNeighbours(node)) {
            if (DFS(currNode)) {
                hasCycle = true;
                break;
            }
        }
        cache.put(node, hasCycle);
        return hasCycle;
    }

    boolean DFSUnDirected(int node, int parentNode) {
        if (cache.containsKey(node))
            return cache.get(node);

        if (visited.containsKey(node) && visited.get(node))
            return true;
        visited.put(node, true);

        boolean hasCycle = false;
        for (int currNode : getNeighbours(node)) {
            if (DFSUnDirected(currNode, node) && node != parentNode) {
                hasCycle = true;
                break;
            }
        }
        cache.put(node, hasCycle);
        return hasCycle;
    }


    private int[] getNeighbours(int node) {
        return g.get(node).toArray();
    }
}
