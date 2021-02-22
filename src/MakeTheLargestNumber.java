import java.util.Arrays;

public class MakeTheLargestNumber {

    String largestNumber(int[] a) {
        String temp = "";
        for (int e : a)
            temp += e;

        char[] chars = temp.toCharArray();

        Arrays.sort(chars);

        return new StringBuilder(new String(chars)).reverse().toString();
    }
}
