public class Segregate3Elements {
    void segregate3Elements(int[] a) {
        //base

        int p1 = 0, p2 = n - 1, i = 0;
        while (i <= p3) {
            if (a[i] == 1) {
                swap(a, i, p1);
                i++;
                p1++;
            } else if (a[i] == 3) {
                swap(a, i, p3);
                i++;
                p3--;
            } else {
                i++;
            }
        }
    }
}
