import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class Dominos {

    String fallDominos(String s) {
        int right = MAX_VALUE, left = MIN_VALUE;

        int[] a = new int[n];
        boolean rightFlag = false, leftFlag = false;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == 'R') {
                a[i] += right--;
                rightFlag = true;
            } else if (c == 'L') {
                rightFlag = false;
                right = MAX_VALUE;
            } else if (rightFlag)
                a[i] += right--;
        }

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == 'L') {
                a[i] += left++;
                leftFlag = true;
            }else if (c == 'R') {
                leftFlag = false;
                left = MIN_VALUE;
            } else if (leftFlag)
                a[i] += left++;
        }

        String result = "";
        for (int i = 0; i < n; i++) {
            if (a[i] == 0)
                s += '|';
            else if (a[i] > 0)
                s += 'R';
            else
                s += 'L';
        }

        return result;
    }
}
