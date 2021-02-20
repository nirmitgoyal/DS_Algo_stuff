import models.Node;

public class Diameter {
    int RESULT = 0; //this will be the result

    int diameter(Node me) {
        //base(can be multiple)
        if (me == null)
            return 0;

        //hypothesis
        int leftResult = diameter(me.L);
        int rightResult = diameter(me.R);

        //induction
        int temp = <max(leftResult, rightResult) + 1>; //relation if i am NOT the root node for the result
        int ans = max(temp, <leftResult + rightResult + 1>); //relation if i am the root node for the result
        RESULT = max(RESULT, ans);

        return temp;
    }
}
