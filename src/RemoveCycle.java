import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*


 */
public class RemoveCycle {
    static Map<Integer, List<Integer>> g = new HashMap<>();

    static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
//        g.put(1, new ArrayList<>(Arrays.asList(2,4,5)));
//        g.put(2, new ArrayList<>(Arrays.asList(3)));
//        g.put(3, new ArrayList<>(Arrays.asList(2,4)));
//        g.put(4, new ArrayList<>(Arrays.asList(1,3)));
//        g.put(5, new ArrayList<>(Arrays.asList(1)));
//        System.out.println(Arrays.toString(isCyclePresent(new int[]{1, 2, 3,4,5})));

//        g.clear();
//        g.put(1, new ArrayList<>(Arrays.asList(2,5)));
//        g.put(2, new ArrayList<>(Arrays.asList(3)));
//        g.put(3, new ArrayList<>(Arrays.asList(2,4)));
//        g.put(4, new ArrayList<>(Arrays.asList(3)));
//        g.put(5, new ArrayList<>(Arrays.asList(1)));
//        System.out.println(Arrays.toString(isCyclePresent(new int[]{1, 2, 3,4,5})));

        g.put(1, new ArrayList<>(Arrays.asList(2)));
        g.put(2, new ArrayList<>(Arrays.asList(1)));
        System.out.println(Arrays.toString(isCyclePresent(new int[]{1, 2, 3})));

    }

    static int[] isCyclePresent(int[] nodes) {
        int[] ans = new int[2];

        for (int node : nodes) {
            ans = DFSUnDirectedWithCache(node, -1);
            if (ans != null)
                return ans;
        }

        return null;
    }

    static private int[] DFSUnDirectedWithCache(int node, int parentNode) {
        if (visited.contains(node) && node != parentNode)
            return new int[]{node, parentNode};

        visited.add(node);

        for (int currNode : getNeighbours(node))
            if (DFSUnDirectedWithCache(currNode, node) != null
                    && currNode != parentNode)
                return new int[]{currNode, node};

        visited.remove(node);

        return null;
    }

    static private Integer[] getNeighbours(int node) {
        List<Integer> list = g.get(node);

        if (list == null || list.isEmpty())
            return new Integer[0];

        Integer[] a = new Integer[list.size()];
        return list.toArray(a);
    }
}
