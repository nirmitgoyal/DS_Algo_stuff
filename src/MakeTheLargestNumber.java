import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MakeTheLargestNumber {

    String largestNumber(List<Integer> a) {
        String result = "";
        List<String> listOfDigits = new ArrayList<>();

        for (int e : a)
            listOfDigits.add(String.valueOf(e));

        Collections.sort(listOfDigits, new CustomComparator());

        for (String e : listOfDigits)
            result += e;

        return result;
    }

    static class CustomComparator implements Comparator<String> {
        public int compare(String first, String second) {
            return -first.compareTo(second);
        }
    }
}
