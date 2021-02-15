package utils;


import java.util.Arrays;
import java.util.Map;

public class Utils {

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

    public static boolean isPrime(int n) { //O(sqrt(n))
        if (n < 2)
            return false;

        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    static public boolean areEqual(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        if (m1.size() != m2.size())
            return false;

        return m1.entrySet().stream()
                .allMatch(e -> e.getValue().equals(m2.get(e.getKey())));
    }

    static public boolean areEqualWithArrayValue(Map<String, String[]> m1, Map<String, String[]> m2) {
        if (m1.size() != m2.size())
            return false;

        return m1.entrySet().stream()
                .allMatch(e -> Arrays.equals(e.getValue(), m2.get(e.getKey())));
    }
}
