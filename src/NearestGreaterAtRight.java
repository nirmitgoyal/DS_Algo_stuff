import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NearestGreaterAtRight {

    List<Integer> nearestGreaterAtRight(int[] a) {
        List<Integer> ans = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) 
                ans.add(-1);
            else if (!isElementGreaterThanOrEqualToStackTop(s, a[i])) 
                ans.add(stack.peek());
            else {
                while (!stack.isEmpty() && isElementGreaterThanOrEqualToStackTop(s, a[i])) 
                    stack.pop();

                if (stack.isEmpty())
                    ans.add(-1);
                else
                    ans.add(stack.peek());
            }

            stack.push(a[i]);
        }

        Collections.reverse(ans); //since iterating from the end
        return ans;
    }

    private boolean isElementGreaterThanOrEqualToStackTop(Stack<Integer> s, int value){
        return value >= s.peek();
    }
}
