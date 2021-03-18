import models.Node;

//Note: only <> & base conditions need to change
//Note: it's not necessary to follow everything concretely
public class TreeDPTemplate {
    int RESULT = INIT; //this will be the result

    int fun(Node me) {
        //base(can be multiple)
        if (me == null)
            return 0;

        //hypothesis
        int lResult = fun(me.L);
        int rResult = fun(me.R);

        //induction
        int temp = <>; //relation if i am NOT the root node for the result
        int ans = max / min / etc(temp, <>); //relation if i am the root node for the result && including left & right result
        RESULT = max / min / etc(RESULT, ans);

        return temp;
    }
}
