import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class isCyclePresent {
    Map<Integer, List<Integer>> g;

    Set<Integer> visited = new HashSet<>();
    Map<Integer, Boolean> cache = new HashMap<>();

    boolean isCyclePresent(int[] nodes) {
        int n = nodes.length;
        for (int i = 0; i < n; i++)
            if (DFSWithCache(i))
                return true;

        return false;
    }

    private boolean DFS(int node) {//become overall O(n^2) with this old approach
        if (visited.contains(node)) //if visited
            return true;

        visited.add(node); //visit

        for (int neighbour : getNeighbours(node))
            if (DFS(neighbour))
                return true;

        visited.remove(node); //unvisit

        return false;
    }

    private boolean DFSWithCache(int node) {//overall O(n) with this approach
        if (cache.containsKey(node))//for optimization
            return cache.get(node);

        if (visited.contains(node))
            return true;
        visited.add(node);

        boolean hasCycle = false;
        for (int neighbour : getNeighbours(node))
            if (DFSWithCache(neighbour)) {
                hasCycle = true;
                break;
            }

        visited.remove(node);
        cache.put(node, hasCycle);//for optimization
        return hasCycle;
    }

    private boolean DFSUnDirected(int node, int parentNode) {
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


    private Integer[] getNeighbours(int node) {
        List<Integer> list = g.get(node);

        Integer[] a = new Integer[list.size()];
        return list.toArray(a);
    }
}
