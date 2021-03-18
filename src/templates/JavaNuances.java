package templates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JavaNuances {
    void PrimitiveToWrapper() {
        int[] a = new int[]{1, 2, 3, 4, 5};

        Integer[] A = Arrays.stream(a)
                .boxed()
                .toArray(Integer[]::new);
    }

    void WrapperToPrimitive() {
        Integer[] A = new Integer[]{1, 2, 3, 4, 5};

        int[] a = Arrays.stream(A)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    void ListToArray() {
        List<Integer> list = new ArrayList<>();

        Integer[] a = new Integer[list.size()];
        a = list.toArray(a);
    }

    void ArrayToList() {
        Integer[] a = new Integer[]{1, 2, 3, 4, 5}; //convert primitive type to Wrapper 1st

        List<Integer> list = new ArrayList<>(Arrays.asList(a));
    }

    void LinkedHashMapFirstAndast(){
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("dummy", 2);

        String first = map.keySet().iterator().next();
        String last = String.valueOf(map.keySet().toArray()[map.size() - 1]);
    }

    void reverseArray(){
        //create a new array and copy elements from the end
    }
}
