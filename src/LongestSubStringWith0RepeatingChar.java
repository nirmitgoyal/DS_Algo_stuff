import static java.lang.Math.max;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWith0RepeatingChar {

  int longestSubStringWith0RepeatingChar(char[] s) {
    int n = s.length;
  
    Map<Character, Integer> map = new HashMap<>();
    int
        nextStartIndex = 0,
        maxLength = 1;

    for (int i = 0; i < n; i++) {
      char c = s[i];

      if (map.containsKey(c)) {
        nextStartIndex = map.get(c) + 1;
      }

      maxLength = max(maxLength, i - nextStartIndex + 1);

      map.put(c, i);
    }

    return maxLength;
  }
}
