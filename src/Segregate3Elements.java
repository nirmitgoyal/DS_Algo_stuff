import java.util.List;

import static java.util.Collections.swap;

public class Segregate3Elements {

    void segregate3Elements(List<Integer> a) { // 1 2 3
        int
                _1 = 0,
                _3 = a.size() - 1,
                i = 0;

        while (i <= _3) {
            if (a.get(i) == 1) {
                swap(a, i, _1); //have to
                _1++;
            } else if (a.get(i) == 3) {
                swap(a, i, _3);
                _3--;
            } else {
                i++;
            }
        }
    }
}
