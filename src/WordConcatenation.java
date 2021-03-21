import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Integer.MAX_VALUE;

public class WordConcatenation {
    Set<String> set=new HashSet<>(); //set of words //input

    Set<String> cache = new HashSet<>();

    boolean canForm(String word) {
        int n = word.length();
        for (int i = 1; i < n; i++) { //from 1, since i is non-inclusive in substring()
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, n);

            if ((set.contains(prefix) && set.contains(suffix))
             || (set.contains(prefix) || canForm(suffix))) //recurse
                return true;
        }

        return false;
    }

    boolean canForm2(String word) {
        if (cache.contains(word))
            return true;

        int n = word.length();
        for (int i = 1; i < n; i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, n);

            if ((set.contains(prefix) && set.contains(suffix))
             || (set.contains(prefix) || canForm2(suffix))) {
                cache.add(word);
                return true;
            }
        }

        cache.add(word);
        return false;
    }


    Map<String, Integer> cache2 = new HashMap<>();

    int minBreaks(String word) {
        return minBreaksHelper(word, 1);
    }

    private int minBreaksHelper(String word, int count) {
        if (set.contains(word))
            return 0;

        if (cache2.containsKey(word))
            return cache2.get(word);

        int
                n = word.length(),
                result = MAX_VALUE; //
        for (int i = 1; i < n; i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, n);

            if (set.contains(prefix) && set.contains(suffix)) {
//                System.out.println("prefix = " + prefix);
//                System.out.println("suffix = " + suffix);
//                System.out.println("count = " + count);
//                System.out.println();
                result = count;
            } else if (set.contains(prefix) && minBreaksHelper(suffix, count + 1) != MAX_VALUE) {
//                    System.out.println("prefix = " + prefix);
//                    System.out.println("suffix = " + suffix);
//                    System.out.println("count = " + count);
//                    System.out.println("suffixCount = " + suffixCount);
//                    System.out.println();
                result = Math.min(result, count + minBreaksHelper(suffix, count + 1));
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
