import models.Return;

import java.util.Arrays;

public class BasicCalc {
    int basicCalcHelper2(char[] s, int i) {
        int ans = 0;
        char op = '+';

        while (i < s.length) {
            int number = 0;

            if (s[i] == '+') {
                op = '+';
            } else if (s[i] == '-') {
                op = '-';
            } else if (s[i] == ')') {
                return ans;
            } else if (s[i] == '(') {
                number = calculateHelper(s, i++);
            } else if (isDigit(s[i])) {
                number = s[i] - '0';
                while (i != s.length - 1 && isDigit(s[i + 1])) {
                    number *= 10;
                    i++;
                    number += s[i] - '0';
                }
            }

            if (op == '+') {
                ans += number;
            } else {
                ans -= number;
            }

            i++;
        }

        return ans;
    }

    int basicCalc(char[] s) {
        return basicCalcHelper2(s, 0);
//        return basicCalcHelper(s, 0).ans;
    }

    //wrong
    private Return basicCalcHelper(String s, int i) {
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
                    Return returnValue = basicCalcHelper(s, i + 1);
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
