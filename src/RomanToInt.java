public class RomanToInt {

//    init map: {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}

    int romanToInt(char[] s) {
        int prev = map.get(s[n - 1]);
        int sum = prev;

        for (int i = n - 2; i >= 0; i--) {
            int curr = map.get(s[i]);

            if (curr < prev)
                sum -= curr;
            else
                sum += curr;

            prev = curr;
        }

        return sum;
    }
}
