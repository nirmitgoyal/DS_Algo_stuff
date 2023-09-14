import static java.util.Collections.swap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {

  static int partition(List<Integer> a) { //here k/pivot is the last element
    int end = a.size();
    int pivot = a.get(end - 1);

    int p = end - 2,
        i = 0; // total 3 variables: pivot, pointer/p, i/iterator

    while (i <= p) { //<= confirmed
      if (a.get(i) <= pivot) {
        i++;
      } else {
        swap(a, i, p);
        p--;
      }
    }

    swap(a, i, end - 1);
    return i;
  }

  public static void main(String[] args) {
    List<Integer> a;

    a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 3));
    partition(a);
    System.out.println(a.toString());

    a = Arrays.asList(1, 6, 2, 4, 7, 6, 3);

    partition(a);
    System.out.println(a.toString());

    a = new ArrayList<>(Arrays.asList(3, 3, 3, 3, 3, 3, 3));
    partition(a);
    System.out.println(a.toString());

    a = new ArrayList<>(Arrays.asList(7, 8, 3, 4, 5, 6, 3));
    partition(a);
    System.out.println(a.toString());

    a = new ArrayList<>(Arrays.asList(8, 3, 4, 5, 2, 3));

    partition(a);
    System.out.println(a.toString());

  }
}
