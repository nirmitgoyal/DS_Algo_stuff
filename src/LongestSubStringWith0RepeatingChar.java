import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

public class LongestSubStringWith0RepeatingChar {

    int longestSubStringWith0RepeatingChar(String s) {
        int n = s.length();
        if (n <= 1)
            return n;

        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, max = 0;

        while (end < n) {
            char c = s.charAt(end);
            if (map.containsKey(c) && map.get(c) >= start) //map.get(c) >= start, since we are not removing old chars from map
                start = map.get(c) + 1;

            max = max(end - start + 1, max);

            map.put(c, end);
            end++;
        }

        return max;
    }
}
