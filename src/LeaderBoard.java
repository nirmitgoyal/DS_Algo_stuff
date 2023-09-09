import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Leaderboard {

  Map<Integer, Integer> scoreMap = new HashMap<>();
  Map<Integer, Integer> tree = new TreeMap<>(Collections.reverseOrder());

  public void addScore(int id, int score) {
    int oldScore = scoreMap.getOrDefault(id, 0);

    // for scoreMap:
    int newScore = oldScore + score;
    scoreMap.put(id, newScore);

    // for treemap:
    if (oldScore != 0) {
      int count = tree.get(oldScore);

      if (count == 1) {
        tree.remove(oldScore);
      } else {
        tree.put(oldScore, count - 1);
      }
    }

    tree.put(newScore, tree.getOrDefault(newScore, 0) + 1);
  }

  public int top(int k) {
    int
        sum = 0,
        left = k;

    for (int key : tree.keySet()) {
      int count = tree.get(key);
      sum += key * Math.min(count, left);

      left -= count;

      if (left == 0) {
        break;
      }
    }

    return sum;
  }

  public void reset(int id) {
    // for scoreMap:
    scoreMap.remove(id);

    // for treemap:
    if (scoreMap.get(id) != null) {
      int oldScore = scoreMap.get(id);

      int count = tree.get(oldScore);

      if (count == 1) {
        tree.remove(oldScore);
      } else {
        tree.put(oldScore, count - 1);
      }
    }
  }

  //Using pq: ____________________________________________________________________________________
  Map<Integer, Integer> map = new HashMap<>();

  public void addScore1(int playerId, int score) {
    map.put(playerId, map.getOrDefault(playerId, 0) + score);
  }

  public int top1(int K) {

    // A min-heap in java containing entries of a hash map. Note that we have to provide
    // a comparator of our own to make sure we get the ordering right of these objects.
    PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));

    for (Entry<Integer, Integer> entry : map.entrySet()) {
      heap.offer(entry);
      if (heap.size() > K) {
        heap.poll();
      }
    }

    int total = 0;
    for (Entry<Integer, Integer> integerIntegerEntry : heap) {
      total += integerIntegerEntry.getValue();
    }

    return total;
  }

  public void reset1(int playerId) {
    map.put(playerId, 0);
  }
}
