import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class LengthOfLongestSubstringTwoDistinct {

  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int n = s.length();

    int left = 0;
    int right = 0;
    Map<Character, Integer> map = new HashMap<>(); // character -> its rightmost position

    int max_len = 0;

    while (right < n) {
      map.put(s.charAt(right), right);

      // slidewindow contains k characters
      if (map.size() == 3) {
        // delete the leftmost character
        int index_to_delete = Collections.min(map.values());
        map.remove(s.charAt(index_to_delete));

        // move left pointer of the slidewindow
        left = index_to_delete + 1;
      }

      max_len = Math.max(max_len, right - left + 1);
      right++;
    }

    return max_len;
  }
}
