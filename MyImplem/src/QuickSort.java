import java.util.Arrays;

public class QuickSort {
    public static <T extends Comparable<T>> int partition(T[] arr, int lo, int hi) {
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (arr[j].compareTo(arr[hi]) < 0) {
                T tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        T tmp = arr[i];
        arr[i] = arr[hi];
        arr[hi] = tmp;
        return i;
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr, int lo, int hi) {
        if (lo < hi) {
            int pos = partition(arr, lo, hi);
            if (pos < 0) return;
            quickSort(arr, lo, pos - 1);
            quickSort(arr, pos + 1, hi);
        }
    }
    public static <T extends Comparable<T>> void sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        String[] names = {
                "Peter",
                "Pierre",
                "Pierre",
                "Guillaume",
                "Siegfried",
                "Oliver",
                "Charles",
                "Kim",
        };
        QuickSort.sort(names);
        System.out.println(Arrays.toString(names));
    }
}
