import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumsofallKsizedsubarraysinanarray {

    ArrayList<Integer> FindMaximumsOfAllKSizedSubarraysInAnArray(int[] a, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty()
                    && dq.peekFirst() == k - 1)
                dq.pollFirst();

            if (!dq.isEmpty()
                    && dq.peekLast() <= a[i])
                dq.pollLast();

            dq.push(i);

            if (i >= k - 1)
                ans.add(a[dq.peekFirst()]);
        }

        return ans;
    }
}
