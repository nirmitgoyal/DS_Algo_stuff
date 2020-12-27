public class HIndex {
    int hIndex(int[] a) {// 3 3 1 0 5
        int n = a.length;
        int[] map = new int[n + 1];//1 based index//Eg: n = 5

        for (int e : a) {
            if (e >= n)//
                map[n]++;
            else
                map[e]++;
        }//1 1 0 2 0 1
        for (int i = (map.length - 1 - 1); i >= 0; i--) {
            map[i] += map[i + 1]; //number of publications with i+ references
        }//5 4 3 3 1 1
        for (int i = (map.length - 1); i >= 0; i--) {
            if (map[i] >= i)
                return i;
        }

        return 0;//not 1
    }
}
