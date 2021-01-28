import java.util.Stack;

public class ReverseStack {

    static Stack<Object> stack = new Stack<>();

    void reverse(Stack stack) {
        if (!stack.isEmpty()) {
            Object e = stack.pop();
            reverse(stack);
            insertAtBottom(e);
        }
    }

    private void insertAtBottom(Object e) {
        if (stack.size() == 0) {
            stack.push(e);
        } else {
            Object popped = stack.pop();
            insertAtBottom(e);
            stack.push(popped);
        }
    }
}
