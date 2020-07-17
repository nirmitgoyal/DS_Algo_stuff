import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    ArrayList<Integer> topKFrequentElements(int[] a, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Element> pq = new PriorityQueue<>(new CustomCollectionSort());

        //fill hashmap with element -> count

        map.forEach((element, count) -> {
            pq.add(new Element(element, count));
        });

        for (int i = 0; i < k; i++) {//assuming k are there
            ans.add(pq.poll().element);
        }
        return ans;
    }

    // CustomCollectionSort compare template
    class CustomCollectionSort implements Comparator<Element> {
        public int compare(Element e1, Element e2) {
            return -e1.count.compareTo(e2.count);
        }
    }

    class Element {
        public Integer element, count;

        public Element(Integer element, Integer count) {
        }
    }
}
