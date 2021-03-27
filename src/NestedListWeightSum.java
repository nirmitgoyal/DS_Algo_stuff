import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum {


    int nestedListWeightSum(List<NestedInteger> nestedList) {
        int sum = 0;
        int d = 1;

        Queue<NestedInteger> q = new LinkedList<>();
        q.addAll(nestedList);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int times = 0; times < count; times++) {
                NestedInteger e = q.poll();
                if (e.isInteger())
                    sum += e.getInteger() * d;
                else
                    q.addAll(e.getList());
            }

            d++;
        }

        return sum;
    }

    //    https://leetcode.com/problems/nested-list-weight-sum-ii
    int nestedListWeightSumReverse(List<NestedInteger> nestedList) {
        int sum = 0;
        int prevSum = 0;

        Queue<NestedInteger> q = new LinkedList<>();
        q.addAll(nestedList);

        while (!q.isEmpty()) {
            int levelSum = 0;

            int count = q.size();
            for (int times = 0; times < count; times++) {
                NestedInteger e = q.poll();
                if (e.isInteger())
                    levelSum += e.getInteger() * d;
                else
                    q.addAll(e.getList());
            }

            prevSum += levelSum;
            sum += prevSum;
        }

        return sum;
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger();

        // Constructor initializes a single integer.
        public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
