import java.util.List;

public class GenerateAllStringsWithNMatchedParentheses {
    List<String> result;

    void generateParen(int n) {
        generateParenHelper(n, "");
    }

    private void generateParenHelper(int n, String s) {
        if (s.length() == 2 * n) {
            result.add(s);
            return;
        }

        generateParenHelper(n, s + '(');
        generateParenHelper(n, s + ')');
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    void generateParenWithPruning(int n) {
        generateParenHelper(n, "", 0, 0);
    }

    private void generateParenHelper(int n, String s, int rCount, int lCount) {
        if (s.length() == 2 * n) {//1. Complete
            result.add(s);
            return;
        }

        //2. Check for all possibilities(here 2)
        if (lCount < n)//3. Check for validity //validity
            generateParenHelper(n, s + "(", rCount, lCount + 1);//4. Do //5. Recurse to solve
        if (rCount < lCount) //validity
            generateParenHelper(n, s + ")", rCount + 1, lCount);
    }
}
