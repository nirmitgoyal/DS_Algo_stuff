import static java.lang.Math.min;
import static utils.Utils.isSafe;

public class JumpToTheEnd {

    int JumpToTheEnd(int[] a) {//3 2 5 1 1 9 3 4 // O(n^2)
        int n = a.length;

        int[] minJumps = new int[n]; //min jumps required for i
        minJumps[0] = 0;

        for (int i = 1; i < n; i++)//fill other values by Integer.MAX_VALUE
            minJumps[i] = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
            for (int times = 0; times < a[i]; times++)
                if (isSafe(i + times, n))
                    minJumps[i + times] = min(minJumps[i + times], minJumps[i] + 1);

        return minJumps[n - 1];
    }

    public int JumpToTheEnd_O_n_Leetcode(int[] a) {
        int n = a.length;
        if (n <= 1)
            return 0;

        // max position one could reach starting from index <= i
        int maxPos = a[0];
        // max number of steps one could do inside this jump
        int maxSteps = a[0];

        int jumps = 0;
        for (int i = 1; i < n; ++i) {
            // if to reach this point one needs one more jump
            if (maxSteps < i) {
                jumps++;
                maxSteps = maxPos;
            }

            maxPos = Math.max(maxPos, a[i] + i);
        }

        return jumps;
    }

    int JumpToTheEnd_O_n_Youtube(int[] a) {//3 2 5 1 1 9 3 4 // O(n)
        int n = a.length;

        if (n <= 1)
            return 0;

        int ladder = a[0], stairs = a[0];
        int jumps = 0;

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
