import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.Integer.MAX_VALUE;

public class WordConcatenation {
    public static Map<String, Integer> cache2 = new HashMap<>(); //extension over brute force
    public static Map<String, Boolean> cache = new HashMap<>(); //extension over brute force

    boolean wordConcatenation(String s, Set<String> words) {
        return canForm(s, words); //helper fun, just to keep consistency with the extended problem
    }

    private boolean canForm(String word, Set<String> set) {
        if (cache.containsKey(word)) //extension over brute force
            return true; //extension over brute force

        int n = word.length();
        for (int i = 1; i < n; i++) { //since i is non-inclusive in substring()
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, n);

            if (set.contains(prefix)
                    && (set.contains(suffix) || canForm(suffix, set))) { //recurse
                cache.put(word, true); //extension over brute force
                return true;
            }
        }

        cache.put(word, false); //extension over brute force
        return false;
    }

    int minBreaks(String word, Set<String> set) {
        return canForm2(word, set, 1);
    }

    private int canForm2(String word, Set<String> set, int count) {
        if (set.contains(word))
            return 0;

        if (cache2.containsKey(word))
            return cache2.get(word);

        int n = word.length(), result = MAX_VALUE;
        for (int i = 1; i < n; i++) { //since i is non-inclusive in substring()
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, n);

            if (set.contains(prefix) && (set.contains(suffix))) {
//                System.out.println("prefix = " + prefix);
//                System.out.println("suffix = " + suffix);
//                System.out.println("count = " + count);
//                System.out.println();
                result = count;
            } else {
                int suffixCount = canForm2(suffix, set, count + 1);
                if (set.contains(prefix) && suffixCount != MAX_VALUE) {
//                    System.out.println("prefix = " + prefix);
//                    System.out.println("suffix = " + suffix);
//                    System.out.println("count = " + count);
//                    System.out.println("suffixCount = " + suffixCount);
//                    System.out.println();
                    result = Math.min(count + suffixCount, result);
                }
            }
        }

        cache2.put(word, result);
        return result;
    }

//    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        set.add("s");
//        set.add("ngl");
////        set.add("sngl");// uncomment to make 1 more case
//        set.add("skfk");
//
//        System.out.println(minBreaks("snglskfk", set));
//    }
}
