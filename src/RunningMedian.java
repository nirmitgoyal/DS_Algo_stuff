import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMedian {

    List<Integer> runningMedians(int[] a) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();//pass the custom comparator

        for (int e : a) {
            addElements(e, minHeap, maxHeap);
            balance(minHeap, maxHeap);
            result.add(median(minHeap, maxHeap));
        }

        return result;
    }

    private void addElements(int e, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.isEmpty() || e <= maxHeap.peek())
            maxHeap.add(e);
        else
            minHeap.add(e);
    }

    private void balance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (minHeap.size() > maxHeap.size() + 1)
            maxHeap.add(minHeap.poll());
    }

    private Integer median(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else if (minHeap.size() > maxHeap.size())
            return minHeap.peek();
        else
            return (maxHeap.peek() + minHeap.peek()) / 2;
    }
}
