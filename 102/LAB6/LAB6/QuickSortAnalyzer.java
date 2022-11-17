package LAB6;

import java.util.Arrays;

public class QuickSortAnalyzer extends SortAnalyzer{

    int k = getK();

    @Override
    public Comparable[] sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public void sort(Comparable[] a, int from, int to) {
        if (from >= to) {
            return;
        }
        int p = partition(a, from, to);
        sort(a, from, p);
        sort(a, p + 1, to);
    }

    private int partition(Comparable[] a, int from, int to) {
        Comparable pivot = a[from];
        int i = from - 1;
        int j = to + 1;
        while (i < j) {
            i++; while (compare(a[i], pivot) < 0) {i++;}
            j--; while (compare(a[j], pivot) > 0) {j--;}
            if (i < j) {
                swap(a, i, j);
            }
        }
        return j;
    }

    private void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
      //RandomArrayGenerator generator1 = new RandomArrayGenerator();
      QuickSortAnalyzer analyzer1  = new QuickSortAnalyzer();
      Comparable[] arr1 = {2,4,1,3,5};

      System.out.println(Arrays.toString(arr1));
      System.out.println(Arrays.toString(analyzer1.sort(arr1)));
    }
}
