public class FirstMissingPositiveInteger {

    int firstMissingPositiveInteger(int[] a) { // -2, 4, 1 , 0, 9 -> 2
        for(int i = 0; i < n; i++)
            while((a[i] > 0 && a[i] <= n) && a[i] != a[a[i] - 1]) //while elements are not in their correct position, put them in their correct position
                swap(a,  i, a[i] - 1);

        for(int i = 0; i < n; i++)
            if(a[i] != (i + 1))
                return (i + 1);

        return n + 1;
    }
}

