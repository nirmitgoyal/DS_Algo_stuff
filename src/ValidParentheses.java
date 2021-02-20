import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    Map<Character, Character> map = new HashMap<>();

    private void init() {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    boolean validParentheses(String s) {
        init();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)
                    && (stack.isEmpty() || stack.pop() != map.get(ch)))
                return false;

            stack.push(ch);
        }

        return stack.isEmpty();
    }
}
