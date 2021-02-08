import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumsofallKsizedsubarraysinanarray {

    List<Integer> FindMaximumsOfAllKSizedSubarraysInAnArray(int[] a, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            //remove from front, if out of window
            if (!dq.isEmpty()
                    && dq.peekFirst() < i - k + 1)
                dq.pollFirst();

            //remove from back, if newcomer is >= every last element
            while (!dq.isEmpty()
                    && a[i] >= a[dq.peekLast()])
                dq.pollLast();

            //Always insert me in DQ, bcoz you don't know the future elements
            dq.addLast(i);

            if (i >= (k - 1)) //if there is a window
                result.add(a[dq.peekFirst()]);
        }

        return result;
    }
}
