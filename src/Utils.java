public class Utils {
    public static boolean isSafe(int i, int n) {
        return i >= 0 && i < n;
    }

    public static boolean isEqual(Map<K, V> m1, Map<K, V> m2) {
        if (m1.size() != m2.size())
            return false;

        m1.forEach((key, value) -> {
            if (!m1.get(key).equals(m2.get(key)))
                return false;
        });

        return true;
    }
}
