package LAB6;

import java.util.Arrays;

public class GeneralizedQuickSort2 extends SortAnalyzer {

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

        int[] pivotsI = partition(a, from, to);

        sort(a, from, pivotsI[0] - 1); // from 0 to 1st pivot

        for (int i = 0; i < pivotsI.length - 1; i++) {
            sort(a, pivotsI[i] + 1, pivotsI[i + 1]-1); // nth pivot to n+1th pivot
        }

         //sort(a, pivotsI[pivotsI.length-1] + 1, to);

    }

    private int[] partition(Comparable[] arr, int from, int to) {
        int n = 0;
        int[] pivots = new int[k - 1];
        for (int i = 0; i < k - 1; i++) // choosing pivots
        {
            pivots[i] = n;
            n++;
        }

        /* for (int i = 0; i < pivots.length - 1; i++) // sorting pivots in each other
        {
            if (compare(arr[pivots[i]], arr[pivots[i + 1]]) > 0) {
                swap(arr, pivots[i], pivots[i + 1]);
            }
        } */

        // int l = pivots[0]-1;
        Comparable[] temp = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < pivots.length; i++) {
            System.out.println(i);
            pivots[i] = partition1(arr, from, to, temp[i]);
        }
        return pivots;
       }

        public int partition1(Comparable[] arr, int from, int to, Comparable pivot)
        {
            
            int l = from - 1;
            int j = to + 1;

            while (true) {
                do {
                    l++;
                } while ( compare(arr[l], pivot)<=0);

                do {
                    j--;
                } while (compare(arr[j], pivot)>0);

                if (l >= j) {
                    return j;
                    
                }
                swap(arr, l, j);
            }
        
    }


    private void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        GeneralizedQuickSort2 analyzer1 = new GeneralizedQuickSort2();
        Comparable[] arr1 = { 2, 4, 1, 3, 5,0,9};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(analyzer1.partition(arr1, 0, arr1.length-1)));
        System.out.println(Arrays.toString(arr1));
        //System.out.println(Arrays.toString(analyzer1.sort(arr1)));
    }
}
