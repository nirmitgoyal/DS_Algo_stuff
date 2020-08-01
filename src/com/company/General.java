package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.round;
import static java.util.Collections.swap;

class Scratch {
    //    https://www.interviewbit.com/problems/minimize-the-absolute-difference/

    //    https://www.geeksforgeeks.org/next-greater-element-in-same-order-as-input/
    //    https://www.geeksforgeeks.org/next-greater-element/
    //    Approach: Do this for every element from back(3 steps):
    //    Step1: Pop from the stack till the top is <= curr(and stack is not empty).
    //    Step2: Now if stack is not empty, then top is NGE, else, NGE is null for this element.
    //    Step3: Now, push this element in stack
    Stack<Integer> s=new Stack();

    {
        for (int i = n - 1; i >= 0; i--) {
            while ((s.peek() <= a[i]) && !s.isEmpty())
                s.pop();

            if (!s.empty())
                System.out.println("null");
            else
                System.out.println(a[i] + ":" + s.peek());

            s.push(a[i]);
        }
    }

    //    https://www.geeksforgeeks.org/longest-common-substring-dp-29/
    //    https://www.geeksforgeeks.org/print-longest-common-substring/
    //    see: https://www.youtube.com/watch?v=BysNXJHzCEs

    //    https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
    //    see: https://www.youtube.com/watch?v=NnD96abizww

    //    https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
    //    use: Another Dynamic Programming Solution (Variation of Longest Common Subsequence Problem)

    //    https://www.geeksforgeeks.org/?p=12832
    //    https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
    //    very tough
    //    use: https://www.youtube.com/watch?v=fV-TF4OvZpk and the git code of it

    //    https://www.geeksforgeeks.org/merge-k-sorted-arrays-set-2-different-sized-arrays/
    //    https://www.geeksforgeeks.org/merge-k-sorted-arrays/
    //    https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
    //    https://www.geeksforgeeks.org/merge-k-sorted-linked-lists-set-2-using-min-heap/
    //    use pQ of size k method
    //    pq of type:   class Entry{ int data, arrayIndex, index}

    //    https://www.geeksforgeeks.org/lru-cache-implementation/
    //    https://www.geeksforgeeks.org/program-for-least-recently-used-lru-page-replacement-algorithm/ here key is same as value
    //    Method: Store in a map: key->Node. Node{data/value, prev, next}
    //    Remember to iniialize DLL with 2 nodes head and tail with dummy values.
    //    We have to implement our own DLL.
    //    use this code:    2. Optimized Approach: https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/.


    //    https://www.geeksforgeeks.org/nearly-sorted-algorithm/
    //    use min heap(priorityQ) method: https://www.geeksforgeeks.org/sort-a-nearly-sorted-array-using-stl/
    //    see https://youtu.be/yQ84lk-EXTQ?t=567
    //    O(k*logk) + O((n-k)*logK) = O(nlogK)
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    //    https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
    //    approach 0:  O((n-k)*k)=O(nk) (brute force) - Sliding window/2 pointer method
    //    approach 1: n*klogk: Using heap(priorityQ) of k size
    //    approach 2: n: Using dequeue. https://www.youtube.com/watch?v=Szyj6BY9iSA

    //    https://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/
    //    use: brute force

    //    https://www.geeksforgeeks.org/find-a-pair-swapping-which-makes-sum-of-two-arrays-same/
    //    use: hashing/set method. Find the formula(diff/2 + x) using calculation.

    //    https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/
    //    use: https://www.youtube.com/watch?v=fZ3p2Iw-O2I

    //    https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
    //    method1: https://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
    //    method2: DP - https://youtu.be/GO5QHC_BmvM
    //    use method2
    //    BFS will not give answer here

    //    https://leetcode.com/problems/max-points-on-a-line/
    //    https://www.geeksforgeeks.org/count-maximum-points-on-same-line/
    //    O(n^2 * Log min(a, b))

    //    https://www.geeksforgeeks.org/word-break-problem-trie-solution/
    //    https://www.geeksforgeeks.org/word-break-problem-dp-32/
    //    https://leetcode.com/problems/word-break-ii/
    //    solution: dp+trie
    //    use: https://www.youtube.com/watch?v=WepWFGxiwRs
    //    https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/BreakMultipleWordsWithNoSpaceIntoSpace.java#L75
    //    in this code, replace dict.contains(str) with trie.search(s)
    //    leetcode's problem solution: https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/BreakMultipleWordsWithNoSpaceIntoSpace.java#L113

    //    use: https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array-set-2
    //    https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
    //    https://leetcode.com/problems/first-missing-positive/

    //    https://leetcode.com/problems/count-of-smaller-numbers-after-self/
    //    approach(use merge sort): https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76583/11ms-JAVA-solution-using-merge-sort-with-explanation
    //    Here, instead of sorting indexes, take a class for every number:
    //    class Number {
    //       int data,index;
    //    }

    //    https://leetcode.com/problems/longest-increasing-path-in-a-matrix
    //    solution: dfs(this will not be able the print the sequence(leave this part of printing sequence)), complexity: O(mn)

    //    https://leetcode.com/problems/longest-consecutive-sequence

    //    https://stackoverflow.com/questions/34057683/strategy-to-win-game-if-players-can-take-upto-4-coins
    //    works for any "can-take-upto-k-coins". Answer always is: 1st preson wins if n%(k+1) == 0

    //    https://www.geeksforgeeks.org/count-number-of-ways-to-cover-a-distance/
    //    see https://www.youtube.com/watch?v=eREiwuvzaUM

    //    PS: egg may not break on any floor
    //    see https://www.youtube.com/watch?v=3hcaVyX00_4
    //    https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
    //    start both floors and eggs with 0

    //    https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
    //    https://www.geeksforgeeks.org/subset-sum-problem-osum-space/
    //    https://www.geeksforgeeks.org/partition-problem-dp-18/
    //    see: https://www.youtube.com/watch?v=s6FhG--P7z0
    //    see: https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/SubsetSum.java
    //    read https://stackoverflow.com/a/56223870
    //    related problem(tough): https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/

    //    https://www.geeksforgeeks.org/edit-distance-dp-5/
    //    see https://www.youtube.com/watch?v=MiqoA-yF-0M

    //    use: https://www.youtube.com/watch?v=vBdo7wtwlXs
    //    https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
    //    https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/
    //    take 3 vars: ladderLen, stairs, jumps/count

    //    https://www.youtube.com/watch?v=BOt1DAvR0zI
    //    https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
    //    use: https://youtu.be/ER4ivZosqCg?t=414 (use quick sort partition algo twice, forward and backward - chose a pivot as index 1(best))

    //    https://www.geeksforgeeks.org/trapping-rain-water/
    //    use approach 2 - O(n),O(n), and approach 4 - O(n),O(1): https://leetcode.com/problems/trapping-rain-water/solution/

    //    https://leetcode.com/problems/container-with-most-water/

    //    https://www.geeksforgeeks.org/median-of-two-sorted-arrays/
    //    https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
    //    see: https://www.youtube.com/watch?v=LPFhl65R7ww
    //    code: https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java#L20

    //    For DP questions, mostly use Tushar's methods
    //    https://www.youtube.com/watch?v=Y0ZqKpToTic.
    //    https://www.youtube.com/watch?v=_fgjrs570YE
    //    https://www.geeksforgeeks.org/coin-change-dp-7/

    //    https://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
    //    use: Method 3 (Using Hashing)
    static ArrayList<Integer> order = new ArrayList<>(Arrays.asList(4, 6, 2, 1));

    //    https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
    //    Note: we have to match the count too
    //    use 2 pointers method: https://youtu.be/eS6PZLjoaq8?t=632 - O(n)
    Map<Character, Integer> sMap = new HashMap<>();//char->count //all chars set to 0
    Map<Character, Integer> patternMap = new HashMap<>();

    {
        while (r < n) {
            if (isConditionStatisfied()) {//O(26)
                while (isConditionStatisfied()) {
                    length = (r - l) + 1;
                    min = min(min, length);
                    patternMap.put(s[l], (patternMap.get(s[l]) - 1));
                    l++;
                }
            } else {
                patternMap.put(s[r], (patternMap.get(s[r]) + 1));
                r++;
            }
        }
    }


//    https://www.geeksforgeeks.org/algorithms-gq/pattern-searching/
//    https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
//    My own O(n+m) string search algo:
    int subString(String pattern, String text){
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> textMap = new HashMap<>();
        //initialize both maps with count 0 for all chars

        for (int i = 0; i < pattern.length(); i++) {
            char keyPattern = pattern.charAt(i);
            patternMap.put(keyPattern, (patternMap.get(keyPattern) + 1));

            char keyText = text.charAt(i);
            textMap.put(keyText, (textMap.get(keyText) + 1));
        }

        if (textMap.equals(patternMap))//override equals method
            return index;

        int startIndex = 0, endIndex = pattern.length();

        while (endIndex < text.length()) {
            char keyStart = text.charAt(startIndex);
            char keyEnd = text.charAt(endIndex);

            textMap.put(keyStart, textMap.get(keyStart) - 1);
            textMap.put(keyEnd, textMap.get(keyEnd) + 1);

            index = compare(textMap, patternMap);
            if (index != -1)
                return index;

            startIndex++;
            endIndex++;
        }

        return -1;
    }

    //    https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
    //    use this method:    https://www.hackerrank.com/challenges/truck-tour/editorial
    {
        start = 0;
        end = n - 1;
        sum = 0;
        set;

        while (start != (end + 1) % n) {
            petrol = p[start];
            dist = d[start];

            sum += petrol - dist;

            if (sum >= 0) {
                set.put(start);
                start = (start + 1) % n;
            } else {
                if (set.contains(start)) {
                    return -1;
                }
                end = start;
                sum = 0;
                start = (start + 1) % n;
            }
        }

        return start;
    }


    //    https://www.geeksforgeeks.org/minimum-number-appends-needed-make-string-palindrome/
    //    https://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/
    //    O(n^2)
    {
        String extra = "";

        while (!isPalindrome(s)) {
            extra += s[0];
            s = s.substring(1, n);
        }
    }

    //    https://www.geeksforgeeks.org/merge-two-sorted-arrays-in-constant-space-using-min-heap/
    //    bad question; leave it
    {
        smallest = pq.peek()
        if (a1[i] > smallest) {
            temp = a[i];
            a[i] = pq.poll();
            pq.insert(temp);
        }
    }

    //    https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
    //    https://www.youtube.com/watch?v=8LusJS5-AGo
    //    MY SOLUTION
    private static Integer knapsack01(int n, ArrayList<Integer> v, ArrayList<Integer> w, int W) {
        //base

        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                Integer bagValue = 0;
                Integer rem;
                Integer weight = w.get(i - 1);
                if (weight > 0 && weight <= j) {
                    Integer amount = min(v.get(i - 1), j / weight);
                    bagValue = amount * weight;
                    rem = j - bagValue;
                    bagValue += dp[i - 1][rem];
                }
                dp[i][j] = max(dp[i - 1][j], bagValue);
            }
        }
        return dp[n][W];
    }

    //    https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
    //    https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
    //    https://leetcode.com/problems/min-stack/
    //    A1: take 1 more stack - min, which will keep minimum element corresponding to every value in stack; O(1), O(n)
    //    A2: The idea is to store the gap between the min value and the current value; O(1), O(1)
    //    similar logic for max
    //    A2:
    int min;
    Stack<Integer> stack;

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0);
            min = x;
        } else {
            stack.push(x - min);//Could be negative if min value needs to change
            if (x < min) min = x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        int pop = stack.pop();

        if (pop < 0) min = min + (-pop);//If negative, increase the min value

    }

    public int top() {
        int top = stack.peek();
        if (top > 0) {
            return (top + min);
        } else {
            return (min);
        }
    }

    public int getMin() {
        return min;
    }

    //    use: https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/:
    //    another method: https://www.geeksforgeeks.org/queue-based-approach-for-first-non-repeating-character-in-a-stream/
    static Node head, tail;

    static class Node {
        char data;
        Node prev, next;

        public Node(char data) {
            this.data = data;
            prev = next = null;
        }
    }

    static void delete(Node node) {
        if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    static void append(Node node) {
        node.prev = tail;
        tail.next = node;
        tail = tail.next;
    }

    static class Value {
        int c;
        Node node;

        public Value(int c, Node node) {
            this.c = c;
            this.node = node;
        }
    }

    private static void firstNonRepeatingCharInStream(String s) {
        //
        Node dummy = new Node('-');

        head = dummy;
        tail = dummy;

        Node node = new Node(s.charAt(0));
        append(node);


        Map<Character, Value> m = new HashMap<>();

        m.put(s.charAt(0), new Value(1, node));
        System.out.println(s[0]);

        for (int i = 1; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i))) {
                Value value = m.get(s.charAt(i));

                if (value.c == 1) {
                    delete(value.node);

                    value.c = 2;
                    m.put(s.charAt(i), value);
                }

                if (head.next != null) {
                    System.out.println(head.next.data);
                } else {
                    System.out.println("-1");
                }
            } else {
                node = new Node(s.charAt(i));
                m.put(s.charAt(i), new Value(1, node));
                append(node);
                System.out.println(head.next.data);
            }
        }

    }

    //    https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
    //    use: https://www.youtube.com/watch?v=Pw6lrYANjz4
    //    note that we can sell then buy a particular stock on the same day also
    private static Long maxBuySellKTimes(Integer n, ArrayList<Long> a, Integer K) {
        if (K == 0 || n == 0) {
            return 0L;
        }

        long T[][] = new long[K + 1][n];

        for (int i = 1; i < T.length; i++) {
            Long maxDiff = -a.get(0);
            for (int j = 1; j < T[0].length; j++) {
                maxDiff = max(maxDiff, T[i - 1][j - 1] - a.get(j - 1));
                T[i][j] = max(T[i][j - 1], a.get(j) + maxDiff);
            }
        }
//        printActualSolution(T, prices);
        return T[K][n - 1];

    }

    //    https://www.geeksforgeeks.org/stock-buy-sell/
    //    loop the array, and use 2 while loops to achieve local minima and maxima. Use only 1 temp variable i to iterate
    //    another solution: assign value to k in maxBuySellKTimes
    private static Long maxBuySell(long n, ArrayList<Long> a) {
        if (n == 0 || n == 1)
            return 0L;

        ArrayList<Pair> result = new ArrayList<>();

        for (int i = 0; i < n; ) {
            Pair pair = new Pair();
            while (a.get(i + 1) <= a.get(i) && i <= n - 2) {
                i++;
            }

            if (i == n - 1)
                break;
            pair.first = i;
            i++;

            while (a.get(i) >= a.get(i - 1) && i <= n - 1) {
                i++;
            }
            pair.second = i - 1;
            result.add(pair);
        }


        int size = result.size();
        //or no profit
        if (size == 0) {
            return 0L;
        }

        Long ans = 0L;
        for (int i = 0; i < size; i++) {
//            out.print("(" + result.get(i).first + " " + result.get(i).second + ") ");
            Pair pair = result.get(i);
            ans += (a.get(pair.second) - a.get(pair.first));
        }
        return ans;
    }

    //    https://stackoverflow.com/questions/39322019/using-a-map-to-find-subarray-with-given-sum-with-negative-numbers/39322103#39322103
    //    https://stackoverflow.com/a/33472576
    //    https://www.geeksforgeeks.org/find-subarray-with-given-sum/
    //    https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
    //    https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/ ::           geeks solution is wrong
    //    https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/ //here reqSum=0
    //    handles -ve
    //    Method: Track currSum from index 0 to i. Put this currSum in map(currSum->index). Now, if (currSum - reqSum) is present in map,
    //    then it mean that the we found the reqSum from index=m.get(currSum - reqSum) till i.
    private static void printSubarrays(ArrayList<Integer> a, int reqSum) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> initial = new ArrayList<>();
        initial.add(-1);
        map.put(0, initial);
        int currSum = 0;

        // Loop across all elements of the array
        for (int i = 0; i < a.size(); i++) {
            currSum += a.get(i);
            // If point where (currSum - reqSum) is present in map, it means that between that
            // point and this, the sum has to equal reqSum
            if (map.containsKey(currSum - reqSum)) {   // Subarray found
                List<Integer> startIndices = map.get(currSum - reqSum);
                //if we have to just count the subarrays, then
                // count+=startIndices.size()
                for (int start : startIndices)
                    System.out.println("Start: " + (start + 1) + "\tEnd: " + i);
            }

            List<Integer> newStart;
            newStart = map.get(currSum);

            if (newStart == null)
                newStart = new ArrayList<>();

            newStart.add(i);
            map.put(currSum, newStart);
        }
    }

    //https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
    //see:    https://www.youtube.com/watch?v=GuTPwotSdYw
    static String s;

    void printPermu(int start, int end) {
        if (end - start == 0) {//length is 0
            System.out.println(s);
            return;
        }

        for (int i = start; i < end; i++) {
            swap(s, i, start);
            printPermu(start + 1, end);
            swap(s, i, start);//backtrack
        }
    }

    //    https://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
    //    intersection
    void intersection(a1, a2) {
        i = 0, j = 0;
        while (i != n1 || j != n2) {
            if (a[i] == a[j]) {
                System.out.println(a[i]);
                i++;
                j++;
            } else if (a[i] > a[j]) {
                j++;
            } else
                i++;
        }
    }

    //    https://www.geeksforgeeks.org/submatrix-sum-queries/
    //    use: https://www.youtube.com/watch?v=-d8KbQVx-mM

    //    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
    //    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/ //replace k=2
    //    O(n)
    private void solve(int k) {
        ArrayList<Integer> count = new ArrayList<>(n);

        count[0] = 1;
        for (int i = 1; i < count.size(); i++) {
            count[i] = 0;
        }

        for (int i = 0, j = 0; j < n; j++, i++) {
            s[i] = s[j];

            if (i > 0) {//
                int prevI = i - 1;

                if (s[i] == s[prevI]) {
                    count[i] = count[prevI] + 1;
                } else {
                    count[i] = 1;
                }
            }

            if (count[i] == k) {
                i -= k;
            }
        }

        return s.substr(0, i);
    }

    //    https://www.youtube.com/watch?v=VmogG01IjYc
    //    https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
    //    https://www.geeksforgeeks.org/median-of-stream-of-running-integers-using-stl/
    void median(ArrayList<Integer> a) {

        for (int i = 0; i < a.size(); i++) {
            addElement(a.get(i));
            balanceSize();
            System.out.println(calcMedian());
        }

    }

    private void addElement(Integer e) {
        if (maxHeap.size() == 0 || e < maxHeap.peek()) {
            maxHeap.add(e);
        } else
            minHeap.add(e);
    }

    static PriorityQueue<Integer> bigHeap, smallHeap;

    private void balanceSize() {

        if (maxHeap.size() > minHeap.size()) {
            bigHeap = maxHeap;
            smallHeap = minHeap;
        } else {
            bigHeap = minHeap;
            smallHeap = maxHeap;
        }

        if (bigHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(bigHeap.poll());
        }
    }

    private Double calcMedian() {
        if (smallHeap.size() == bigHeap.size()) {
            return ((double) smallHeap.peek() + (double) bigHeap.peek()) / 2;
        } else
            return (double) bigHeap.peek();
    }

    //    https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
    //    https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
    //    O(n*n)
    public int longestPalindromeSubstring(char s[]) {
        int max = 1, x, y, length;

        for (int i = 0; i < s.length; i++) {
            //for even length longest palin substring
            x = i;
            y = i + 1;
            length = 0;
            while ((x >= 0 && y < s.length) && s[x] == s[y]) {
                x--;// in these type of cases index can become out of bound
                y++;
                length += 2;
            }
            max = max(max, length);

            //for odd length longest palin substring
            x = i - 1;
            y = i + 1;
            length = 1;
            while ((x >= 0 && y < s.length) && s[x] == s[y]) {
                x--;
                y++;
                length += 2;
            }
            max = max(max, length);
        }

        return max;
    }

    //    https://leetcode.com/problems/largest-rectangle-in-histogram/
    //    https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
    //    https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
    //    very tough
    //    O(n^2): Brute force: one by one consider all bars as starting points and calculate area of all rectangles starting with every bar. Finally return maximum of all possible areas.
    //
    //    O(n):
    //    Explaination 1:
    //    For every bar in the histogram, consider it to be included in the required rectangle of maximum area. Now calculate the area of the rectangle that it can form.
    //    This bar can form the rectangle between its previous smaller bar and next smaller bar.
    //    So we need index of previous and next smaller bar for every bar. For this we use stack and keep pushing in it the indexes of bars which are longer than the one at the top.
    //    If a incoming bar is of smaller height than the bar at the top of stack, we have got the right smaller index for the bar at the top of stack.
    //    So we pop the top element i.e index of bar whose area we're going to calculate.
    //    models.Index of previous smaller is now saved at the top of the stack and next smaller is the incoming bar that is waiting to be pushed in the stack. Now we can calculate its area.
    //    We'll do this for every bar and keep track of the maximum area. Handle the corner cases like left smaller index of the first bar and right smaller index of last bar.

    //    Explaination 2:
    //    For every bar, if I can calculate the area under histogram such that it is the largest bar in the continuous set of bars and take there maximum value I will get my solution.
    //    Now, how to calculate the area under histogram such that it is the largest bar in continuous set of bars ? => Simple, I need to find first bar on left as well as right that are
    //    smaller than current bar!
    //    But naive complexity for this would be O(n^2) , so we use stack.
    //    How stack solution works?
    //    We push elements to stack. But before pushing we check if current element is smaller than stack top element because it will imply I found out the right smaller index for element on
    //    top of stack! What about left smaller index? It was pushed right before pushing the stack top element!
    static ArrayList<Integer> a;
    static Integer maxArea = 0, n = a.size(), area = 0, i;
    static Stack<Integer> s = new Stack<>();//contains indexes

    Integer maxArea() {
        for (i = 0; i < n; i++) {
            if ((s.size() == 0) || (a[i] >= a[s.peek()])) {
                s.push(i);
                i++;
            } else {
                maxArea = calculateArea();
            }
        }

        while (s.size() != 0)
            maxArea = calculateArea();

        return maxArea;
    }

    //poll from stack and calculate area
    private Integer calculateArea() {
        Integer popped = s.pop();
        Integer peeked = null;
        if (!s.isEmpty())
            peeked = s.peek();
        Integer barArea = a[popped];

        if (s.size() == 0)
            area = barArea * i;
        else
            area = barArea * ((i - peeked) - 1);

        return max(maxArea, area);
    }

    //Maximum size rectangle binary sub-matrix with all 1s
    //https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/

    void quickSort(Integer start, Integer end) {
        if (start > end) {
            return;
        }

        Integer partitionIndex = partition(start, end);
        quickSort(start, partitionIndex - 1);
        quickSort(partitionIndex + 1, end);
    }

    //take 'pivotElement' as last element and an index as 'partitionIndex' as starting index.
    //Loop and compare the array element with 'pivotElement', if the current element is smaller than 'pivotElement', then swap the current element with the element at partitionIndex
    private Integer partition(Integer start, Integer end) {
        Integer pivotElement = a.get(end);
        Integer partitionIndex = start;

        for (int i = start; i < end; i++) {
            if (a.get(i) <= pivotElement) {
                swap(i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(partitionIndex, end);

        return partitionIndex;
    }

    // Merges two subarrays of arr[] in place
    // First subarray is arr[l .. m]
    // Second subarray is arr[m+1 .. r]
    void merge(Integer l, Integer m, Integer r) {
        Integer actualM = m + 1;//
        Integer n1 = actualM - l;
        Integer n2 = r - m;

        ArrayList<Integer> L = new ArrayList<>();
        ArrayList<Integer> R = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            L.add(a.get(l + i));
        }
        for (int j = 0; j < n2; j++) {
            R.add(a.get(actualM + j));
        }

        Integer i = 0, j = 0;
        Integer k = l;//

        while (i < n1 && j < n2) {
            Integer left = L.get(i);
            Integer right = R.get(j);
            if (left <= right) {
                a.set(k, left);
                i++;
            } else {
                a.set(k, right);
                j++;
            }
            k++;
        }

        while (i < n1) {
            a.set(k, L.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            a.set(k, R.get(j));
            j++;
            k++;
        }
    }

    //divide of merge sort
    //    3 Steps:
    //    1. Find mid
    //    2. Call this divide function again
    //    3. call merge function
    void divide(Integer l, Integer r) {
        if (l > r) {
            return;
        }

        Integer mid = (l + r) / 2;

        divide(l, mid);
        divide(mid + 1, r);

        merge(l, mid, r);
    }

    //    https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/
    //    https://www.geeksforgeeks.org/find-four-numbers-with-sum-equal-to-given-sum/
    //N^2
    void sumAsSum(ArrayList<Integer> a, Integer sum) {
        Map<Integer, Pair> m = new HashMap<>();
        Integer n = a.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Pair pair = new Pair();
                pair.first = i;
                pair.second = j;
                m.put(a.get(i) + a.get(j), pair);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Pair pair = new Pair();
                pair.first = i;
                pair.second = j;

                Integer remSum = sum - (a.get(i) + a.get(j));

                if (m.containsKey(remSum) && anotherPair.first != i && anotherPair.second != j && anotherPair.second != i && anotherPair.first != j) {//for all distinct elements
                    System.out.println(i + " " + j + " " + anotherPair.first + " " + anotherPair.second);
                }
            }
        }
    }

    //    https://www.geeksforgeeks.org/box-stacking-problem-dp-22/
    //    https://www.youtube.com/watch?v=9mod_xRB-O0
    public int maxHeight(Dimension[] input) {
        //get all rotations of box dimension.
        //e.g if dimension is 1,2,3 rotations will be 2,1,3  3,2,1  3,1,2  . Here length is always greater
        //or equal to width and we can do that without loss of generality.
        Dimension[] allRotationInput = new Dimension[input.length * 3];
        createAllRotation(input, allRotationInput);
//        Integer[] array = new Integer[4];
//        Collections.sort(array);
        //sort these boxes in non increasing order by their base area.(length X width)
        Arrays.sort(allRotationInput);

        //apply longest increasing subsequence kind of algorithm on these sorted boxes.
        int T[] = new int[allRotationInput.length];
        int result[] = new int[allRotationInput.length];

        for (int i = 0; i < T.length; i++) {
            T[i] = allRotationInput[i].height;
            result[i] = i;
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 0; j < i; j++) {

                if ((allRotationInput[i].length < allRotationInput[j].length) && (allRotationInput[i].width < allRotationInput[j].width)) {
                    if (T[j] + allRotationInput[i].height > T[i]) {
                        T[i] = T[j] + allRotationInput[i].height;
                        result[i] = j;
                    }
                }
            }
        }

        //find max in T[] and that will be our max height.
        //Result can also be found using result[] array.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < T.length; i++) {
            if (T[i] > max) {
                max = T[i];
            }
        }

        return max;
    }

    //create all rotations of boxes, always keeping length greater or equal to width
    private void createAllRotation(Dimension[] input,
                                   Dimension[] allRotationInput) {
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            allRotationInput[index++] = Dimension.createDimension(
                    input[i].height, input[i].length, input[i].width);
            allRotationInput[index++] = Dimension.createDimension(
                    input[i].length, input[i].height, input[i].width);
            allRotationInput[index++] = Dimension.createDimension(
                    input[i].width, input[i].length, input[i].height);

        }
    }

    //    https://www.youtube.com/watch?v=wAyrtLAeWvI
    //    https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/ still calling o(1) space
    //    https://www.geeksforgeeks.org/write-an-iterative-olog-y-function-for-powx-y/

    //    O(n) space: f[i] = max(f[i - 1] + a[i], a[i])
    //    https://www.youtube.com/watch?v=99ssGWhLPUE
    //    https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MaximumSumSubsequence.java

    //    https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
    //method: find the sum of all positive chunks of the array, and return the maximum of it
    private Integer maximumSumSubarray(ArrayList<Integer> a) {
        Integer currSum = 0, maxSum = a.get(0);

        //check for all negative
        for (int i = 1; i < a.size(); i++)
            maxSum = max(maxSum, a.get(i));
        if (maxSum <= 0)
            return maxSum;

        for (int i = 1; i < a.size(); i++) {
            currSum += a.get(i);
            maxSum = max(maxSum, currSum);

            if (currSum < 0)
                currSum = 0;
        }

        return maxSum;
    }

    //    https://www.geeksforgeeks.org/check-string-substring-another/
    private int substring(String s, String substring) {
        n = s.length();
        int m = substring.length();

        for (int i = 0; i <= n - m; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i + j] != substring[j])
                    break;

                if (j == m)
                    return i;
            }
        }

        return -1;
    }

    //    use: https://www.geeksforgeeks.org/maximum-product-subarray-set-2-using-two-traversals/
    //    https://www.geeksforgeeks.org/maximum-product-subarray/
    //    https://www.geeksforgeeks.org/maximum-product-subarray-set-3/

    //    https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
    //    use: https://www.geeksforgeeks.org/print-longest-substring-without-repeating-characters/
    //    method: map(char->latestIndex), vars -  max, currLength, currStart, globalStart. Calculate length only if the element was found earlier and is present after the currStart,
    //    else keep going
    private String longestDistinctSubstring() {
        Map<Character, Integer> map = new HashMap<>();
        int i, max = 1, currLength = 1, currStart = 0, globalStart = 0;

        map.put(s[0], 0);

        for (i = 1; i < s.length(); i++) {
            Character c = s[i];

            if (map.containsKey(c) && map.get(c) >= currStart) {
                updateMax(i, max, currLength, currStart, globalStart);
                currStart = map.get(c) + 1;
            }

            //update map
            map.put(c, i);
        }

        updateMax(i, max, currLength, currStart, globalStart);

        return s.substring(globalStart, globalStart + max);
    }

//    completely different question
//    https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
//    very simple

    void updateMax(int i, int max, int currLength, int currStart, int globalStart) {
        currLength = i - currStart;

        if (currLength > max) {
            max = currLength;
            globalStart = currStart;
        }
    }
    //    https://www.geeksforgeeks.org/find-the-element-that-appears-once/
    //    use: https://www.youtube.com/watch?v=mHfvInveXDQ
    //    make use of isKthBitSet( fun.

    Integer binarySearch(int value) {//return index
        int start = 0, end = n - 1;

        while (start <= end) {
            Integer m = (start + end) / 2;
            Integer aOfMid = a.get(m);

            if (aOfMid == value) {
                return m;
            } else if (value < aOfMid) {
                end = m - 1;
            } else {
                start = m + 1;
            }
        }

        return -1;
    }

    //https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
    //https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
    //use: https://www.youtube.com/watch?v=5BI0Rdm9Yhk
    //pivot is the starting of the sorted array
    int findPivot() {
        int start = 0, end = n - 1;

        //there will never come a case of start>end as there will always be a pivot
        while (true) {
            int m = (start + end) / 2;

            if (a[start] <= a[end]) {//found
                return start;
            } else if (a[m + 1] < a[m]) {//found
                return (m + 1);
            } else {
                if (a[m] < a[start]) {
                    end = m - 1;
                } else {
                    start = m + 1;
                }
            }
        }
    }

    //    https://www.geeksforgeeks.org/counting-inversions/
    //    see: https://www.youtube.com/watch?v=owZhw-A0yWE
    //    we cannot use quick sort bcoz: https://stackoverflow.com/questions/19652758/is-it-possible-to-calculate-the-number-of-count-inversions-using-quicksort
    Integer divideModified(Integer l, Integer r) {
        Integer inversions = 0;

        if (l < r) {
            Integer m = (l + r) / 2;
            inversions += divideModified(l, m);
            inversions += divideModified(m + 1, r);

            inversions += mergeForCountInversions(l, m, r);
        }

        return inversions;
    }

    private Integer mergeForCountInversions(Integer l, Integer m, Integer r) {
        Integer
                actualMid = m + 1,
                n1 = actualMid - l,
                n2 = r - m,
                inversions = 0;

        ArrayList<Integer> L = new ArrayList<>(n1), R = new ArrayList<>(n2);

        for (int i = 0; i < n1; i++) {
            L.add(a.get(l + i));
        }
        for (int i = 0; i < n2; i++) {
            R.add(a.get(actualMid + i));
        }

        Integer i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L.get(i) <= R.get(j)) {
                a.set(k, L.get(i));
                i++;
                k++;
            } else {
                a.set(k, R.get(j));
                j++;
                k++;

                Integer actualI = l + i;
                inversions += actualMid - actualI;//the only addition
            }
        }

        while (i < n1) {
            a.set(k++, L.get(i++));
        }
        while (j < n2) {
            a.set(k++, R.get(j++));
        }

        return inversions;
    }

    //    https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/

    Boolean isKthBitSet(Integer n, Integer k) {
        return (n & (1 << k)) >= 1;
    }

    Boolean CheckIfBinaryRepresentationOfANumberIsPalindrome(Integer n) {
        if (n < 2)
            return true;

        Integer left = 0, right = 4 * 8 - 1;

        while (left < right) {
            if (isKthBitSet(n, left).equals(isKthBitSet(n, right))) {
                left--;
                right++;
            } else {
                return false;
            }
        }

        return true;
    }

    //    https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/TwoStringInterleavingToFormThird.java
    //    https://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/

    //    https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
    //    https://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
    //    also works if some elements are negative
    void sumAsX(ArrayList<Integer> a, Integer sum) {
        Integer n = a.size();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Integer current = a.get(i);
            Integer anotherElement = sum - current;

            if (set.contains(anotherElement))
                System.out.println(current + " " + anotherElement);

            set.add(current);
        }
    }

    //    https://www.geeksforgeeks.org/reverse-words-in-a-given-string/
    String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (!character.equals(' '))
                word.append(character);
            if (character.equals(' ') || i == s.length() - 1) {
                stringBuilder.append(word.reverse()).append(' ');
                word.setLength(0);
            }
        }
        return stringBuilder.reverse().toString().trim();
    }

    //    Problems on Trie:
    //    https://www.geeksforgeeks.org/longest-common-prefix-using-word-by-word-matching/
    //    https://www.geeksforgeeks.org/longest-common-prefix-using-trie/
    String LongestCommonPrefix(Trie.Node node) {
        //  base

        prefix = "";

        while (node.children.size() == 1 && node.endOfWord == F) {
            Entry<Character, Trie.Node> firstEntry = node.children.entrySet().iterator().next();
            Character c = firstEntry.getKey();

            prefix += c;

            node = node.children.get(c);
        }

        return prefix;
    }

    //https://stackoverflow.com/questions/2784514/sort-arraylist-of-custom-objects-by-property
    class CustomCollectionSort implements Comparator<Integer> {

        @Override
        public int compare(Integer first, Integer second) {
            // a and b are elements of input/original arraylist
            Integer indexFirst = Scratch.order.indexOf(first);
            Integer indexSecond = Scratch.order.indexOf(second);

            if (indexFirst != -1 && indexSecond != -1)
                return indexFirst - indexSecond;
            else if (indexFirst != -1)// b not present
                return -1;
            else if (indexSecond != -1)
                return 1;
            else //a and b both are not there in order arraylist
                return first - second;//natural order(ascending)
        }
    }

    /**
     * Utility class to hold dimensions
     */
    class Dimension implements Comparable<Dimension> {
        int height;
        int length;
        int width;

        Dimension(int height, int length, int width) {
            this.height = height;
            this.length = length;
            this.width = width;
        }

        Dimension() {
        }

        static Dimension createDimension(int height, int side1, int side2) {
            Dimension d = new Dimension();
            d.height = height;
            if (side1 >= side2) {
                d.length = side1;
                d.width = side2;
            } else {
                d.length = side2;
                d.width = side1;
            }
            return d;
        }

        /**
         * Sorts by base area(length X width)
         */
        @Override
        public int compareTo(Dimension d) {//it can also return 0, which means that objects are same
            if (this.length * this.width >= d.length * d.width) {
                return -1;//decreasing order
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Dimension [height=" + height + ", length=" + length
                    + ", width=" + width + "]";
        }

        class Pair {
            Integer first, second;

            Pair() {
            }

            Pair(Integer first, Integer second) {
                this.first = first;
                this.second = second;
            }
        }

        ArrayList<Integer> customSort(ArrayList<Integer> a) {
            Collections.sort(a, new CustomCollectionSort());
            a.sort(new CustomCollectionSort());
            a.sort((first, second) -> {
                // a and b are elements of input/original arraylist
                Integer indexFirst = order.indexOf(first);
                Integer indexSecond = order.indexOf(second);

                if (indexFirst != -1 && indexSecond != -1)
                    return indexFirst - indexSecond;
                else if (indexFirst != -1)// b not present
                    return -1;
                else if (indexSecond != -1)
                    return 1;
                else //a and b both are not there in order arraylist
                    return first - second;//natural order(ascending)
            });
            return a;
        }

        private boolean isValid(Integer i, Integer j, Integer c, Integer r) {
            return i >= 0 && j >= 0 && i < r && j < c;
        }


        private int floorSqrt(int x) {
            // Base Cases
            if (x == 0 || x == 1)
                return x;

            // Do Binary Search for floor(sqrt(x))
            int start = 1, end = x, ans = 0;
            while (start <= end) {
                int mid = (start + end) / 2;

                // If x is a perfect square
                if (mid * mid == x)
                    return mid;

                // Since we need floor, we update answer when mid*mid is
                // smaller than x, and move closer to sqrt(x)
                if (mid * mid < x) {
                    start = mid + 1;
                    ans = mid;
                } else   // If mid*mid is greater than xdefaultDownstreamTimeoutMillis
                    end = mid - 1;
            }
            return ans;
        }
    }
}