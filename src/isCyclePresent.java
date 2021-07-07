import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class isCyclePresent {
    Map<Integer, List<Integer>> g = new HashMap<>();

    Set<Integer> visited = new HashSet<>(); // this visited set is just for one node, during its DFS

    boolean isCyclePresent(int[] nodes) {
        for (int node: nodes)
            if (DFS(node))
                return true;

        return false;
    }

    private boolean DFS(int node) {//become overall O(n^2) with this old approach
        if (visited.contains(node)) //if visited
            return true;

        visited.add(node); //visit

        boolean hasCycle = false;
        for (int neighbour : getNeighbours(node))
            if (DFS(neighbour)) {
                hasCycle = true;
                break;
            }

        visited.remove(node); //UNVISIT

        return hasCycle;
    }

    Map<Integer, Boolean> cache = new HashMap<>();
    private boolean DFSWithCache(int node) { //overall O(n) with this approach
        if (cache.containsKey(node)) //for optimization
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

        cache.put(node, hasCycle); //for optimization
        return hasCycle;
    }

    private boolean DFSUnDirectedWithCache(int node, int parentNode) {
        if (cache.containsKey(node))
            return cache.get(node);

        if (visited.contains(node)&& node != parentNode)
            return true;
        visited.add(node);

        boolean hasCycle = false;
        for (int currNode : getNeighbours(node)) {
            if (DFSUnDirectedWithCache(currNode, node) && currNode != parentNode) {
                hasCycle = true;
                break;
            }
        }

        visited.remove(node);

        cache.put(node, hasCycle);
        return hasCycle;
    }

    private Integer[] getNeighbours(int node) {
        List<Integer> list = g.get(node);

        if (list == null || list.isEmpty())
            return new Integer[0];

        Integer[] a = new Integer[list.size()];
        return list.toArray(a);
    }
}
