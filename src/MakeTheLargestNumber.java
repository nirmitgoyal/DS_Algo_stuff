import java.util.Comparator;
import java.util.List;

public class MakeTheLargestNumber {

    String largestNumber(List<Integer> a) {
        String result = "";

        a.sort(new CustomComparator());

        for (Integer e : a)
            result += String.valueOf(e);

        return result;
    }

    static class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer e1, Integer e2) {
            String s1 = String.valueOf(e1);
            String s2 = String.valueOf(e2);

            return (s1 + s2).compareTo(s2 + s1);
        }
    }
}
