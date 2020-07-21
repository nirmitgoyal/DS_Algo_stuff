import java.util.ArrayList;

public class GenerateAllStringsWithNMatchedParentheses {

    ArrayList<String> generateAllStringsWithNMatchedParentheses(int n) {
        ArrayList<String> result = new ArrayList<>();

        generateAllStringsWithNMatchedParenthesesHelper(n, result, 0, 0, "");

        return result;
    }

    private void generateAllStringsWithNMatchedParenthesesHelper(int n, ArrayList<String> result, int leftCount, int rightCount, String s) {
        if (s.length() == 2 * n)
            result.add(s);

        if (leftCount < n)
            generateAllStringsWithNMatchedParenthesesHelper(n, result, leftCount + 1, rightCount, s + "(");
        if (rightCount < leftCount)
            generateAllStringsWithNMatchedParenthesesHelper(n, result, leftCount, rightCount + 1, s + ")");
    }
}
