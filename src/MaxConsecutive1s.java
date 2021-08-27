public class MaxConsecutive1s {

    int maxLength(int num) {
        int bitmask = 1;
        int currLength = 0;
        int ans = 0;

        while (num > 0) {
            if ((num & bitmask) == 1) {
                currLength++;
                ans = Math.max(ans, currLength);
            } else {
                currLength = 0;
            }

            num = num >> 1;
        }

        return ans;
    }

}
