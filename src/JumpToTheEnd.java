import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.min;

public class JumpToTheEnd {
    private static final int MIN_COUNT_REQUIRED_FOR_A_HOP = 1;

    int JumpToTheEnd(int[] a) {//3 2 5 1 1 9 3 4 // O(n^2)
        int n = a.length;

        int[] minJumps = new int[n]; //min jumps required for i

        minJumps[0] = 0;
        //fill other values by MAX_VALUE
        for (int i = 1; i < n; i++)
            a[i] = MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = (i + 1); j < n; j++) {
                if (i + j < n)
                    minJumps[i + j] = min((minJumps[i] + MIN_COUNT_REQUIRED_FOR_A_HOP), minJumps[i + j]);
            }
        }

        return minJumps[n - 1];
    }

    int JumpToTheEnd_O_n(int[] a) {//3 2 5 1 1 9 3 4 // O(n)
        int n = a.length;

        if (n <= 1)
            return 0;

        int ladder = a[0], stairs = a[0];
        int jumps = 1;

        for (int i = 1; i < n; i++) {
            // consume a stair
            stairs--;

            if (i + ladder > ladder)
                ladder = i + ladder;

            if (stairs == 0) {
                jumps++;
                stairs = ladder - i;
            }
        }

        return jumps;
    }
}
