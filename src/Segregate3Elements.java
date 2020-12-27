import static java.util.Collections.swap;

public class Segregate3Elements {

    void segregate3Elements(int[] a) {
        //base

        int p1 = 0, p2 = n - 1, i = 0;
        while (i <= p2) {
            if (a[i] == 1) {
                swap(a, i, p1);
                p1++;
            } else if (a[i] == 3) {
                swap(a, i, p2);
                p2--;
            }
            i++;
        }
    }
}
