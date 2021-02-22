import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

public class LongestSubStringWith0RepeatingChar {

    int longestSubStringWith0RepeatingChar(String s) {
        int n = s.length();
        if (n <= 1)
            return n;

        Map<Character, Integer> map = new HashMap<>();
        int
                nextStartIndex = 0,
                maxLength = 1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (map.containsKey(c) && (map.get(c) >= nextStartIndex)) //map.get(c) >= nextStartIndex, since we are not cleaning the map
                nextStartIndex = map.get(c) + 1;

            maxLength = max(maxLength, i - nextStartIndex + 1);

            map.put(c, i);
        }

        return maxLength;
    }
}
