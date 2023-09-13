import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumsofallKsizedsubarraysinanarray {

    List<Integer> maximumsOfAllKSizedSubarraysDP(int[] a, int k) {
        if (k == 1)
            return a;
        int n = a.length;

        int[] left = new int[n];
        left[0] = a[0];
        int[] right = new int[n];
        right[n - 1] = a[n - 1];

       for (int i = 0; i < n; i++)
           if (i % k == 0)   // block_start
               left[i] = a[i];
           else
               left[i] = Math.max(left[i - 1], a[i]);

       for (int i = n - 1; i >= 0; i--)
           if ((i + 1) % k == 0)   // block_end
               right[i] = a[i];
           else
               right[i] = Math.max(right[i + 1], a[i]);

        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < n - k + 1; i++)
            output.add(Math.max(left[i + (k - 1)], right[i]));

        return output;
    }

    List<Integer> FindMaximumsOfAllKSizedSubarraysInAnArrayDQ(int[] a, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            //remove from back, if newcomer is >= every last element
            while (!dq.isEmpty()
                    && a[i] >= a[dq.peekLast()])
                dq.pollLast();

            //Always insert me in DQ, bcoz you don't know the future elements
            dq.addLast(i);

            //remove from front, if out of window
            if (!dq.isEmpty()
                    && dq.peekFirst() == i - k)
                dq.pollFirst();

            if (i >= k - 1) //if there is a window
                result.add(a[dq.peekFirst()]);
        }

        return result;
    }
}
