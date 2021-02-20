import utils.Utils;

public class ProductExceptSelf {

    int[] productExceptSelf(int[] a) {//1 2 3 4
        int n = a.length;
        int[] ans = new int[n];//24 12 8 6
        int[] l = new int[n];//1 2 6 24
        int[] r = new int[n];//24 24 12 4

        for (int i = 1; i < n; i++)
            l[i] = l[i - 1] * a[i];
        for (int i = (n - 1 - 1); i >= 0; i--)
            r[i] = r[i + 1] + a[i];

        int left = 1, right = 1;
        for (int i = 0; i < n; i++) {
            if (Utils.isSafe(i - 1, n))
                left = l[i - 1];
            if (Utils.isSafe(i + 1, n))
                right = r[i + 1];

            ans[i] = left * right;
        }

        return ans;
    }
}
