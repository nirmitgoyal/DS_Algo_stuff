import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllStringsWithNMatchedParentheses {

    List<String> generateAllStringsWithNMatchedParentheses(int n) {
        return generateAllStringsWithNMatchedParenthesesHelper(n, 0, 0, "");
    }

    private List<String> generateAllStringsWithNMatchedParenthesesHelper(int n, int leftCount, int rightCount, String s) {
        if (s.length() == 2 * n)
            return Arrays.asList(s);

        ArrayList<String> result = new ArrayList<>();

        if (leftCount < n)
            result.add(generateAllStringsWithNMatchedParenthesesHelper(n, leftCount + 1, rightCount, s + "(");
        if (rightCount < leftCount)
            generateAllStringsWithNMatchedParenthesesHelper(n, leftCount, rightCount + 1, s + ")");

        return result;
    }
}
