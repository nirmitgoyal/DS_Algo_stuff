public class ProductExceptSelf {
    int[] productExceptSelf(int[] a) {//1 2 3 4
        int n = a.length;
        int[] ans = new int[n];//24 12 8 6
        int[] l = new int[n];//1 2 6 24
        int[] r = new int[n];//24 24 12 4

        int temp = 1;
        for (int i = 0; i < n; i++) {
            temp *= a[i];
            l[i] = temp;
        }
        temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            temp *= a[i];
            r[i] = temp;
        }

        int left = 1, right = 1;
        for (int i = 0; i < n; i++) {
            if (isSafe(i - 1, n))
                left = l[i - 1];
            if (isSafe(i + 1, n))
                right = r[i + 1];
            ans[i] = left * right;
        }

        return ans;
    }

    private boolean isSafe(int i, int n) {
        return i >= 0 && i < n;
    }
}
