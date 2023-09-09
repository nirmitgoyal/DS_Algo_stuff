import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

class Leaderboard {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> tree = new TreeMap<>(Collections.reverseOrder());

    public void addScore(int id, int score) {
        int oldScore = 0;

        //for map:
        if (map.containsKey(id))
            oldScore = map.get(id);

        int newScore = oldScore + score;
        map.put(id, newScore);

        //for treemap:
        if (map.containsKey(id)) {
            int count = tree.get(oldScore);

            if (count == 1)
                tree.remove(oldScore);
            else
                tree.put(oldScore, count - 1);
        }

        tree.put(newScore, tree.getOrDefault(newScore, 0) + 1);
    }

    public int top(int k) {
        int
                sum = 0,
                left = k;

        Set<Integer> keys = tree.keySet();

        for (int key : keys) {
            int count = tree.get(key);
            sum += key * min(count, left);

            left -= count;

            if (left == 0)
                break;
        }

        return sum;
    }

    public void reset(int id) {
        //for map:
        map.remove(id);

        //for treemap:
        if (map.containsKey(id)) {
            int oldScore = map.get(id);

            int count = tree.get(oldScore);

            if (count == 1)
                tree.remove(oldScore);
            else
                tree.put(oldScore, count - 1);
        }
    }

    //Using pq: ____________________________________________________________________________________
    public void addScore1(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }

    public int top1(int K) {

        // A min-heap in java containing entries of a hash map. Note that we have to provide
        // a comparator of our own to make sure we get the ordering right of these objects.
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry);
            if (heap.size() > K) {
                heap.poll();
            }
        }

        int total = 0;
        Iterator value = heap.iterator();
        while (value.hasNext()) {
            total += ((Map.Entry<Integer, Integer>) value.next()).getValue();
        }

        return total;
    }

    public void reset1(int playerId) {
        map.put(playerId, 0);
    }
}
