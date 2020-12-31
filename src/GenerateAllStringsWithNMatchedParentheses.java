import java.util.ArrayList;
import java.util.List;

public class GenerateAllStringsWithNMatchedParentheses {
    public static final String LEFT_PAREN = "(";
    public static final String RIGHT_PAREN = ")";

    List<String> generateParen(int n) {
        List<String> result = new ArrayList<>();

        generateParenHelper(0, 0, "", n, result);

        return result;
    }

    private void generateParenHelper(int leftCount, int rightCount, String s, int n, List<String> result) {
        if (s.length() == (2 * n)) {
            result.add(s);
            return;
        }

        if (leftCount < n)
            generateParenHelper(leftCount + 1, rightCount, (s + LEFT_PAREN), n, result);
        if (rightCount < leftCount)
            generateParenHelper(leftCount, rightCount + 1, (s + RIGHT_PAREN), n, result);
    }
}
