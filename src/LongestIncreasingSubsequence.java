import static java.lang.Math.max;

import java.util.Map;

public class LongestIncreasingSubsequence {

  Map<Integer, Integer> cache;

  int longestIncreasingSubsequenceLength(int[] a, int index) { //O(n^2)
    //no base needed

    int ans = 1;
    for (int i = 0; i < index; i++) 
      if (a[index] > a[i]) 
        ans = max(ans, longestIncreasingSubsequenceLength(a, i) + 1);

    return ans;
  }

  int longestIncreasingSubsequenceLength2(int[] a, int index) { //O(n)
    if (cache.containsKey(index)) 
      return cache.get(index);

    int ans = 1;
    for (int i = 0; i < index; i++) 
      if (a[index] > a[i]) 
        ans = max(ans, longestIncreasingSubsequenceLength(a, i) + 1);

    cache.put(index, ans);
    return ans;
  }
}
