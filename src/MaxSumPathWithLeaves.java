import models.Node;

import static java.lang.Math.max;

public class MaxSumPathWithLeaves {
    int RESULT = 0; //this will be the result

    int maxSumPathWithLeaves(Node me) {
        //base(can be multiple)
        if (me == null)
            return 0;

        //hypothesis
        int leftResult = maxSumPathWithLeaves(me.L);
        int rightResult = maxSumPathWithLeaves(me.R);

        //induction
        int temp = < max(leftResult, rightResult) + me.data > // max of left & right, coz we'll either take left path or right path;
        int ans = leftResult + rightResult + me.data; //not max / min / etc(<>, temp)
        RESULT = max(RESULT, ans);

        return temp;
    }
}
