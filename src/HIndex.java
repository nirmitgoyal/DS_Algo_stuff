public class HIndex {

    int hIndex(int[] a) {// 3 3 1 0 5
        int n = a.length;
        Integer[] map = new Integer[n + 1]; //1 based index//Eg: n = 5
        int n2 = n+1;

        for (int e : a)
            if (e >= n) //
                map[n]++;
            else
                map[e]++;
        //1 1 0 2 0 1

        for (int i = (n2 - 2); i >= 0; i--)
            map[i] += map[i + 1]; //number of publications with i+ references
        //5 4 3 3 1 1

        for (int i = 0; i < n2; i++) {
            int _1BasedI = i + 1;
            if (map[i] < _1BasedI)
                return _1BasedI - 1;
        }
    }
}
