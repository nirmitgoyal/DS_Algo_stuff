import java.util.HashMap;
import java.util.Map;

public class GeneratePalindrome {

    String generatePalindrome(String sOriginal) {
        char[] s = sOriginal.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        String ans = "";
        Character oddChar = null;

        for (char c : s)
            map.put(c, (map.getOrDefault(c, 0) + 1));

        map.forEach((c, count) -> {
            if (isEven(count))
                ans = append(ans, c, count / 2);//passed String does got change
            else
                if (oddChar != null) {
                    return "NOT_POSSIBLE";
                } else {
                    oddChar = c;
                    ans = append(ans, c, count / 2);
                }
        });

        return ans + oddChar + new StringBuilder(ans).reverse();
    }

    private static String append(String s, Character c, int count) {
        for (int i = 0; i < count; i++)
            s += c;

        return s;
    }
}
