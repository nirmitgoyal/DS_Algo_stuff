public class Mountain {
    boolean isMountain(int[] a) {
        int n = a.length;
        if (n < 3)
            return false;

        String direction = "NONE";

        for (int i = 1; i < n; i++) {
            if (direction == "NONE") {
                if (a[i] > a[i - 1]) {
                    direction = "UP";
                    continue;
                }
            }

            if (direction == "UP") {
                if (a[i] > a[i - 1]) {
                    direction = "UP";
                    continue;
                }
                if (a[i] < a[i - 1]) {
                    direction = "DOWN";
                    continue;
                }
            }

            if (direction == "DOWN") {
                if (a[i] < a[i - 1]) {
                    continue;
                }
            }

            return false;
        }

        return direction == "DOWN";
    }
}
