import java.util.LinkedHashMap;
import java.util.Map;

public class LengthOfLongestSubstringWithKDistinctChars {

    public int lengthOfLongestSubstringKDistinct(char[] s, int k) {
        Map<Character, Integer> map = new LinkedHashMap<>();//char->latestIndex
        int
                nextStartIndex = 0,
                maxLength = 1;

        for (int i = 0; i < n; i++) {
            char c = s[i];

            map.remove(c);
            map.put(c, i);

            if (map.size() > k) {
                char leftMostChar = map.keySet().iterator().next();

                nextStartIndex = map.get(leftMostChar)+1;
                map.remove(leftMostChar);
            }

            maxLength = Math.max(maxLength, (i - nextStartIndex) + 1);
        }

        return maxLength;
    }
}
