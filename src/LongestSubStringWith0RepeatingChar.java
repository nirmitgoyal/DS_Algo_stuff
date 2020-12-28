import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

public class LongestSubStringWith0RepeatingChar {

    int longestSubStringWith0RepeatingChar(String s) {
        int n = s.length();

        if (n <= 1)
            return n;


        Map<Character, Integer> map = new HashMap<>();
        int startIndex = 0, endIndex = 0, maxLength = 1;

        while (endIndex < n) {
            char c = s.charAt(endIndex);

            if (map.containsKey(c) && (map.get(c) >= startIndex)) //map.get(c) >= startIndex, since we are not cleaning the map
                startIndex = map.get(c) + 1;

            maxLength = max(endIndex - startIndex + 1, maxLength);

            map.put(c, endIndex);


            endIndex++;
        }

        return maxLength;
    }
}
