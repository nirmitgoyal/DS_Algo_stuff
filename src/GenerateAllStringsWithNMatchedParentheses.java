import java.util.List;

public class GenerateAllStringsWithNMatchedParentheses {
    List<String> result;

    void generateParen(int n) {
        generateParenHelper(n, "");
    }

    private void generateParenHelper(int n, String paren) {
        if (paren.length() == 2 * n) {
            result.add(paren);
            return;
        }

        generateParenHelper(n, paren + '(');
        generateParenHelper(n, paren + ')');
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    void generateParenWithPruning(int n) {
        generateParenHelper(n, "", 0, 0);
    }

    private void generateParenHelper(int n, String paren, int rCount, int lCount) {
        if (paren.length() == 2 * n) {//1. Complete
            result.add(paren);
            return;
        }

        //2. Check for all possibilities(here 2)
        if (lCount < n)//3. Check for validity //validity
            generateParenHelper(n, paren + "(", rCount, lCount + 1);//4. Do //5. Recurse to solve
        if (rCount < lCount) //validity
            generateParenHelper(n, paren + ")", rCount + 1, lCount);
    }
}
