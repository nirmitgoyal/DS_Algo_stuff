import java.util.HashMap;
import java.util.Map;

public class GeneratePalindrome {

    static String generatePalindrome(String sOriginal) {
        char[] s = sOriginal.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        String ans = "";
        Character oddChar = '';

        for (char c : s)
            map.put(c, (map.getOrDefault(c, 0) + 1));

        map.forEach((c, count) -> {
            if (isEven(count)) {
                ans = append(ans, c, count / 2);//passed String does got change
            } else {
                if (oddChar != '') {
                    return "";
                } else {
                    oddChar = c;
                    ans = append(ans, c, count / 2);
                }
            }
        });

        return ans + oddChar + reverse(ans);
    }

    private static String append(String s, Character c, int count) {
        for (int i = 0; i < count; i++) {
            s += c;
        }
        return s;
    }
}
