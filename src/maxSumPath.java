import models.Node;

public class MaxSumPath {

  int RESULT = 0; //this will be the result

  int maxSumPath(Node root) {
    //base(can be multiple)
      if (root == null) {
          return 0;
      }

    //hypothesis
    int leftResult = maxSumPath(root.L);
    int rightResult = maxSumPath(root.R);

    //induction
    int temp = max(0, max(0, max(l, r)) + root.data > 0 ? root.data : 0);

    int ans = max(temp, l > 0 ? l : 0 + r > 0 ? r : 0 + root.data);
// OR:
//        int temp = <max(
//                max(leftResult, rightResult) + me.data, // max of left & right, coz we'll either take left path or right path
//                me.data, //if max(leftResult, rightResult) was -ve
//                0 //if contributing me makes us -ve
//        );>
//        int ans = max(
//                temp,
//                < leftResult + rightResult + me.data >
//        );
    RESULT = max(RESULT, ans);

    return temp;
  }

}
