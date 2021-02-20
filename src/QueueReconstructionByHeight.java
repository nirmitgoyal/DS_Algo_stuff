import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Element {
    Integer h, c;
}

class CustomComparator implements Comparator<Element> {

    public int compare(Element first, Element second) {
        if (first.h.equals(second.h))
            return first.c.compareTo(second.c);
        return -first.h.compareTo(second.h);
    }
}

public class QueueReconstructionByHeight {

    List<Element> QueueReconstructionByHeight(ArrayList<Element> a) { // [[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]
        List<Element> result = new ArrayList<>();

        a.sort(new CustomComparator()); // [ [7, 0] [7, 1] [6, 1] [5, 0] [5, 2] [4, 4] ]

        for (int i = 0; i < n; i++)
            result.add(a.get(i).c, a.get(i));

        return result; // [ [5, 0] [7, 0] [5, 2] [6, 1] [4, 4] [7, 1]]
    }
}
