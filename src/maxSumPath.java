import models.Node;

public class MaxSumPath {
    int RESULT = 0; //this will be the result

    int maxSumPath(Node me) {
        //base(can be multiple)
        if (me == null)
            return 0;

        //hypothesis
        int leftResult = maxSumPath(me.L);
        int rightResult = maxSumPath(me.R);

        //induction
        int temp = <max(
                max(leftResult, rightResult) + me.data, // max of left & right, coz we'll either take left path or right path
                me.data, //if max(leftResult, rightResult) was -ve
                0 //if contributing me makes us -ve
        );>
        int ans = max(
                temp,
                <leftResult + rightResult + me.data>
        );
        RESULT = max(RESULT, ans);

        return temp;
    }
}
