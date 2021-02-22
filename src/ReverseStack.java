import java.util.Stack;

public class ReverseStack {

    void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int e = stack.pop();
            reverse(stack);
            insertAtBottom(stack, e);
        }
    }

    private void insertAtBottom(Stack<Integer> stack, int e) {
        if (stack.size() == 0) {
            stack.push(e);
        } else {
            int popped = stack.pop();
            insertAtBottom(stack, e);
            stack.push(popped);
        }
    }
}
