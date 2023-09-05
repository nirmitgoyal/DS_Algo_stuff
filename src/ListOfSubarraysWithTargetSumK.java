import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Interval;

public class ListOfSubarraysWithTargetSumK {

  List<Interval> listOfSubarraysWithTargetSumK(int[] a, int targetSum) {
    List<Interval> result = new ArrayList<>();

    Map<Integer, Integer> map = new HashMap<>(); //sum -> index
    map.put(0, -1); // sum 0 found till index: -1

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += a[i];

      if (map.containsKey(sum - targetSum)) {
        result.add(new Interval((map.get(sum - targetSum) + 1), i)); //inclusive interval
      }

      map.put(sum, i);
    }

    return result;
  }
}
