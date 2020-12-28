import java.util.HashMap;
import java.util.Map;

public class Isomorphic {

    boolean isIsomorphic(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length())
            return false;

        return isIsomorphicHelper(s1, s2) && isIsomorphicHelper(s2, s1);
    }

    private boolean isIsomorphicHelper(String s1, String s2) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (!map.containsKey(c1)) {
                map.put(c1, c2);
            } else {
                char mapping = map.get(c1);
                if (mapping != c2)
                    return false;
            }
        }

        return true;
    }
}
