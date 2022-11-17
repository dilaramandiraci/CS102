package LAB6;

import java.util.Arrays;

public class GeneralizedQuickSortAnalyzer extends SortAnalyzer {

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

        sort(a, from, pivotsI[0]-1); // from 0 to 1st pivot

        for (int i = 0; i < pivotsI.length - 1; i++) {
            sort(a, pivotsI[i]+1, pivotsI[i + 1]-1); // nth pivot to n+1th pivot
        }

        System.out.println(to-pivotsI[pivotsI.length-1] );
        //sort(a, pivotsI[pivotsI.length-1] , to);

    }

    public int[] partition(Comparable[] arr, int from, int to) {
        int n = 0;
        int[] pivots = new int[k-1];
        for (int i = 0; i<k-1; i++) // choosing pivots
        {
            pivots[i] = n;
            n++;
        }

        /* for (int i = 0; i < pivots.length - 1; i++) // sorting pivots in each other
        {
            if (compare(arr[pivots[i]], arr[pivots[i + 1]]) > 0) {
                swap(arr, pivots[i], pivots[i + 1]);
            }
        }  */

        //int l = pivots[0]-1;
        Comparable[] temp = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < pivots.length; i++) {
            Comparable pivot = temp[pivots[i]];
            int l = from-1;
            int j = to + 1;
            while (true) {
                l++;
                while (compare(arr[l], pivot) < 0) {
                    l++;
                }
                j--;
                while (compare(arr[j], pivot) > 0) {
                    j--;
                }
                if (l < j) {
                    swap(arr, l, j);
                }
                else 
                {
                    pivots[i] = j+1;
                    break;
                }
                

            }
            //l = pivots[i];
        }
        return pivots;

    }

    private void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        GeneralizedQuickSortAnalyzer analyzer1 = new GeneralizedQuickSortAnalyzer();
        RandomArrayGenerator generator = new RandomArrayGenerator();
        
        Comparable[] arr1 = { 2, 4, 1, 3, 5,9};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(analyzer1.partition(arr1, 0, arr1.length-1)));
        
        System.out.println(Arrays.toString(analyzer1.sort(arr1)));
        System.out.println(analyzer1.getNumberOfComparisons());
        
    }
}
