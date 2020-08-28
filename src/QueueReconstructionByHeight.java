import java.util.ArrayList;
import java.util.Comparator;

class Element {
    public Integer h, c;
}

class CustomCollectionSort implements Comparator<Element> {
    public int compare(Element first, Element second) {
        if (first.h.equals(second.h))
            return first.c.compareTo(second.c);
        return second.h.compareTo(first.h);
    }
}

public class QueueReconstructionByHeight {
    void QueueReconstructionByHeight(ArrayList<Element> a) {
        a.sort(new CustomCollectionSort());

        for (int i = 0; i < n; i++) {
            a.add(a.c, a.get(i));
        }
    }
}
