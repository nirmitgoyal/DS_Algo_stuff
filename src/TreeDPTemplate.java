import models.Node;

//only <> & base conditions need to change
public class TreeDPTemplate {
    int RESULT = INIT; //this will be the result

    int fun(Node me) {
        //base(can be multiple)
        if (me == null)
            return 0;

        //hypothesis
        int leftResult = fun(me.L);
        int rightResult = fun(me.R);

        //induction
        int temp = <>; //relation if i am NOT the root node for the result
        int ans = max / min / etc(<>, temp); //relation if i am the root node for the result
        RESULT = max / min / etc(ans, RESULT);

        return temp;
    }
}
