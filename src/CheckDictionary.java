import java.util.HashMap;
import java.util.Map;

/*
abdhk
cjp


h 0
l 1

 */
public class Solution {

    public static boolean fun(String[] words, String order) {
        //base
        if (words.length == 1)
            return true;


        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        for (char c : order.toCharArray()) {
            map.put(c, i++);
        }

        for (i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int minL = Math.min(word1.length(), word2.length());//5
            boolean flag = true;//f


            for (int times = 0; times < minL; times++) {
                char c1 = word1.charAt(times);//o
                char c2 = word2.charAt(times);//c

                if (c1 != c2) {
                    flag = false;
                }

                if (map.get(c1) < map.get(c2)) {
                    break;
                } else if (map.get(c1) > map.get(c2)) {
                    return false;
                }

            }

            if (flag && word1.length() > word2.length()) {
                return false;

            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(fun(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(fun(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(fun(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
