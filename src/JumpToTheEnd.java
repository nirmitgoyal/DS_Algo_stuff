import static java.lang.Math.min;

public class JumpToTheEnd {
    int JumpToTheEnd(int[] a) {//3 2 5 1 1 9 3 4
        int n = a.length;

        int[] minJumps = new int[n];
        minJumps[0] = 0;
        //fill other vaules by INT_MAX

        for (int i = 0; i < n; i++) {
            int newJump = minJumps[i] + 1;
            for (int j = i + 1; j < min((i + a[i]) + 1, n); j++) {
                minJumps[j] = min(newJump, minJumps[j]);
            }
        }

        return minJumps[n - 1];
    }

}
