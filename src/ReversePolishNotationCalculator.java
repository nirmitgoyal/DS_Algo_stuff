import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static utils.Utils.calculate;

public class ReversePolishNotationCalculator {
    public static final List<Character> OPERATORS = Arrays.asList('+', '-', '*', '/');

    int reversePolishNotationCalculator(char[] s) {
        Stack<Integer> stack = new Stack<>();

        for (char c : s) {
            if (isOperator(c)) {
                int latter = Integer.valueOf(stack.pop());
                int former = Integer.valueOf(stack.pop());

                stack.push(calculate(former, latter, c));
            } else {
                stack.push(Integer.valueOf(c));
            }
        }

        return stack.peek();
    }

    private boolean isOperator(char c) {
        return OPERATORS.contains(c);
    }
}
