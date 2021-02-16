package templates;

import java.util.ArrayList;
import java.util.List;

public class JavaNuances {
    void ListToArray(){
        List<Integer> list = new ArrayList<>();

        Integer[] a = new Integer[list.size()];
        a = list.toArray(a);
    }
}
