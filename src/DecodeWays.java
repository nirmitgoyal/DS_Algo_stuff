public class DecodeWays {

    public int numDecodings(String s) {
        if (s.length() == 0)
            return 1;


        int count = numDecodings(s.substring(1));
        if (s.length() >= 2
                && ((s[0] == '1' || s[0] == '2') && s[1] <= '6')
        )
            count += numDecodings(s.substring(2));

        return count;
    }

    public int numDecodings(int index) {
        if (index == n)
            return 1;


        count = numDecodings(index + 1);
        if (index < n - 1
                && ((s[index] == '1' || s[index] == '2') && s[index + 1] <= '6')
        )
            count += numDecodings(s.substring(index + 2));

        return count;
    }

}
