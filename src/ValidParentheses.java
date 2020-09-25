import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    boolean validParentheses(String s) {
        Map<Character, Character> m = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        m.put(')', '(');
        m.put('}', '{');
        m.put(']', '[');

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (m.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != m.get(ch))
                    return false;
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
