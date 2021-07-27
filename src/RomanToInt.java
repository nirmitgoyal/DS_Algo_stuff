public class RomanToInt {

//    init map: {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}

    int romanToInt(char[] s) {
        init();

        int sum = map.get(s[n-1]);

        for (int i = n - 2; i >= 0; i--) {
            int curr = map.get(s[i]);

            if (curr >= map.get(s[i + 1]))
                sum += curr;
            else
                sum -= curr;
        }

        return sum;
    }
}
