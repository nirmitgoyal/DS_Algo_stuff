import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class isCyclePresent {
    static Map<Integer, List<Integer>> g;

    static Map<Integer, Boolean> visited = new HashMap<>();
    static Map<Integer, Boolean> cache = new HashMap<>();

    //O(n)
    boolean isCyclePresent(int[] nodes) {
        for (int i = 0; i < n; i++)
            if (DFSWithCache(i))
                return true;

        return false;
    }

    boolean DFSWithoutCache(int node) {//become n^2 with this old approach
        if (visited.containsKey(node) && visited.get(node) == true)
            return true;

        visited.put(node, true);

        for (int currNode : getNeighbours(node)) {
            if (DFSWithoutCache(currNode)==true)
                return true;
        }
        visited.put(node, false);

        return false;
    }

    boolean DFSWithCache(int node) {
        if (cache.containsKey(node))//for optimization
            return cache.get(node);

        if (visited.containsKey(node) && visited.get(node) == true)
            return true;

        visited.put(node, true);

        boolean hasCycle = false;
        for (int currNode : getNeighbours(node)) {
            if (DFSWithCache(currNode)) {
                hasCycle = true;
                break;
            }
        }
        visited.put(node, false);

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
            if (DFSUnDirected(currNode, node) && currNode != parentNode) {
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
