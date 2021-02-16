import models.Return;

import java.util.Arrays;
import java.util.List;

import static java.lang.Character.isDigit;
import static utils.Utils.calculate;
import static utils.Utils.isSafeIndex;

public class BasicCalc {
    public static final List<Character> OPERATORS = Arrays.asList('+', '-');

    //not working correctly for all cases on LC
    int basicCalc(String s) {
        s = s.replaceAll(" ", "");

        return basicCalcHelper(s.toCharArray(), 0);
//      return basicCalcHelperWrong(s, 0).ans;
    }

    int basicCalcHelper(char[] s, int index) {
        int n = s.length;
        int sum = 0;
        char op = '+'; //the default op for 1st character of each expression is +

        while (index < n) {
            char c = s[index];
            int number = 0;

            if (isOperator(c)) {
                op = c;
            } else if (c == ')') {
                return sum;
            } else if (c == '(') {
                index++;
                number = basicCalcHelper(s, index);
            } else {
                number = c - '0';
                while (isSafeIndex(index + 1, n) && isDigit(s[index + 1])) { //for cases like "23+..."
                    number = (number * 10) + (s[index] - '0');
                    index++;
                }
            }

            sum = calculate(sum, number, op);

            index++;
        }

        return sum;
    }

    private boolean isOperator(char c) {
        return OPERATORS.contains(c);
    }


    //wrong
    private Return basicCalcHelperWrong(String s, int i) {
        char op = '+';
        int ans = 0;

        while (i < s.length()) {//spaces and ) are skipped
            char c = s.charAt(i);
            if (Arrays.asList('+', '-').contains(c)) {
                op = c;
            } else {
                int value = 0;
                if (isDigit(c)) {
                    value = Integer.valueOf(c);
                } else if (c == '(') {
                    Return returnValue = basicCalcHelperWrong(s, i + 1);
                    value = returnValue.ans;
                    i = returnValue.index;
                }
                if (op == '+') {//not else if
                    ans += value;
                }
                if (op == '-') {
                    ans -= value;
                }
            }
            i++;
        }

        return new Return(ans, i);//just the value matters here
    }
}
