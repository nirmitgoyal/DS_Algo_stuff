public class HIndex {
    int hIndex(int[] a) {// 3 3 1 0 5
        int[] map = new int[n + 1];//1 based index//Eg: n = 5

        for (int i = 0; i < n; i++) {
            if (a[i] >= n)
                map[n]++;
            else
                map[a[i]]++;
        }//1 1 0 2 0 1
        for (int i = (map.length - 1 - 1); i >= 0; i--) {
            map[i] += map[i + 1];
        }//5 4 3 3 1 1
        for (int i = (map.length - 1); i >= 0; i--) {
            if (map[i] >= i)
                return i;
        }
        return 0;//not 1
    }
}
