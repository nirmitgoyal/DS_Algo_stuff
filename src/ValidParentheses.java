import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    boolean validParentheses(String s) {
        Map<Character, Character> forwardMap = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        forwardMap.put('(', ')');
        forwardMap.put('{', '}');
        forwardMap.put('[', ']');
        reverseMap.put(')', '(');
        reverseMap.put('}', '{');
        reverseMap.put(']', '[');

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (reverseMap.containsKey(ch)) {
                if (!stack.isEmpty()) {
                    char pop = stack.pop();
                    if (pop != reverseMap.get(ch))
                        return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
