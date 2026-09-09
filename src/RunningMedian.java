import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class RunningMedian {

  List<Integer> runningMedians(int[] a) {
    List<Integer> result = new ArrayList<>();
    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    for (int e : a) {
      addElements(e, minHeap, maxHeap);
      rebalance(minHeap, maxHeap);
      result.add(median(minHeap, maxHeap));
    }

    return result;
  }

  private void addElements(int e, Queue<Integer> minHeap, Queue<Integer> maxHeap) {
    if (maxHeap.isEmpty() || e <= maxHeap.peek()) 
      maxHeap.add(e);
    else 
      minHeap.add(e);
  }

  private void rebalance(Queue<Integer> minHeap, Queue<Integer> maxHeap) {
    if (maxHeap.size() - minHeap.size() >= 2) 
      minHeap.add(maxHeap.poll());
    else if (minHeap.size() - maxHeap.size() >= 2) 
      maxHeap.add(minHeap.poll());
  }

  private Integer median(Queue<Integer> minHeap, Queue<Integer> maxHeap) {
    if (maxHeap.size() > minHeap.size()) 
      return maxHeap.peek();
    else if (minHeap.size() > maxHeap.size()) 
      return minHeap.peek();
    else 
      return (maxHeap.peek() + minHeap.peek()) / 2;
  }
}
