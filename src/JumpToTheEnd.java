public class JumpToTheEnd {
    int JumpToTheEnd(int[] a) {//3 2 5 1 1 9 3 4
        int[] minJumps = new int[n];
        minJumps[0] = 0;
        //fill other vaules by INT_MAX

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < min(i + 1 + a[i], n); j++) {
                int newJump = minJumps[i] + 1;
                minJumps[j] = Math.min(newJump, minJumps[j]);
            }
        }

        return minJumps[n - 1];
    }

}
