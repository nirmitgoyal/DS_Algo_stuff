package utils;

public class Utils {
    public static boolean isEqual(Map<K, V> m1, Map<K, V> m2) {
        if (m1.size() != m2.size())
            return false;

        m1.forEach((key, value) -> {
            if (!m1.get(key).equals(m2.get(key)))
                return false;
        });

        return true;
    }

    public static String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);

        sb.setCharAt(i, s.charAt(j));
        sb.setCharAt(j, s.charAt(i));

        return sb.toString();
    }

    public static int calculate(int former, int latter, char operator) {
        if (operator == '+')
            return former + latter;
        else if (operator == '-')
            return former - latter;
        else if (operator == '*')
            return former * latter;
        else
            return former / latter;
    }

    public static boolean isSafeIndex(int index, int n) {
        return index >= 0 && index < n;
    }
}
