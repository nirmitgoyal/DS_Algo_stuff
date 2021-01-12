import models.Node;

public class maxSumPath {

    int MAX = 0;

    int maxSumPath(Node me) {
        if (me == null)
            return 0;

        int maxSumPathOfLeftSubtree = maxSumPath(me.L);
        int maxSumPathOfRightSubtree = maxSumPath(me.R);

        MAX = max(
                MAX,
                (maxSumPathOfLeftSubtree + maxSumPathOfRightSubtree + me.data)
        );

        return max(
                (max(maxSumPathOfLeftSubtree, maxSumPathOfRightSubtree) + me.data), // max of left & right, coz we'll either take left path or right path
                me.data,
                0
        );
    }
}
