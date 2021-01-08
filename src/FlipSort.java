import java.util.Arrays;

public class FlipSort {

    public static void sort(int[] a) {
        int n = a.length; //n will change

        while (n > 1) {
            int maxIndex = maxIndex(a, n);

            reverse(a, maxIndex);
            reverse(a, n - 1);

            n--;
        }
    }

    private static int maxIndex(final int[] a, int n) {
        int maxIndex = 0, max = a[0];

        for (int i = 0; i < n; i++)
            if (a[i] > max) {
                max = a[i];
                maxIndex = i;
            }

        return maxIndex;
    }

    private static void reverse(int[] A, int index) { //this fun will be provided
        int len = index + 1;
        int left = 0, right = len - 1;
        while (left < right) {
            int temp = A[left];
            A[left++] = A[right];
            A[right--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 4, 1};
        sort(a);
        System.out.println("a = " + Arrays.toString(a));
    }
}
