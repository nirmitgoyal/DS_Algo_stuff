import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKMostFrequentElements {

    List<Integer> topKMostFrequentElements(int[] a, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); //element -> count
        PriorityQueue<Element> pq = new PriorityQueue<>(new CustomComparator());

        for (int e : a)
            map.put(e, (map.getOrDefault(e, 0) + 1));

        map.forEach((element, count) -> {
            pq.add(new Element(element, count));
        });

        for (int i = 0; i < k; i++) //assuming atleast k elements are there
            result.add(pq.poll().element);

        return result;
    }

    // CustomComparator compare template
    class CustomComparator implements Comparator<Element> {
        public int compare(Element e1, Element e2) {
            return -e1.count.compareTo(e2.count);
        }
    }

    class Element {
        Integer element, count;
    }
}
