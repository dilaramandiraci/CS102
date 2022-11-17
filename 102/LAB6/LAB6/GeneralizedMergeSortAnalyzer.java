package LAB6;

import java.util.Arrays;

public class GeneralizedMergeSortAnalyzer extends SortAnalyzer {

    int k = getK();

    @Override
    public Comparable[] sort(Comparable[] arr) {

        int n = arr.length;
        int p = 0;
        Comparable[][] partitions;

        if (arr.length < 1 || isSorted(arr)) {
            return arr;
        }

        if (n < k) {
            partitions = new Comparable[n][];
            for (int i = 0; i < n; i++) {
                Comparable[] temp = new Comparable[1];

                for (int j = 0; j < 1; j++) {
                    temp[j] = arr[p];
                    p++;
                }
                partitions[i] = temp;
            }
        }

        else {
            int regular = n / k;
            partitions = new Comparable[k][];
            for (int i = 0; i < k - 1; i++) {
                Comparable[] temp = new Comparable[regular];

                for (int j = 0; j < regular; j++) {
                    temp[j] = arr[p];
                    p++;
                }
                sort(temp);
                partitions[i] = temp;
            }

            Comparable[] temp = new Comparable[n - (regular * (k - 1))];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = arr[p];
                p++;
            }
            sort(temp);
            partitions[k - 1] = temp;
        }

        int[] indexes = new int[partitions.length];
        int minIndex = 0;
        int j = 0;

        while (j < arr.length) {
            Comparable min = maxValue(partitions);
            minIndex = 0;

            for (int i = 0; i < partitions.length; i++) {

                if (indexes[i] < partitions[i].length) {
                    if (compare(partitions[i][indexes[i]], min) < 0) {
                        min = partitions[i][indexes[i]];
                        minIndex = i;
                    }
                }
            }
            arr[j] = min;
            j++;
            indexes[minIndex]++;
        }
        return arr;
    }

    public Comparable maxValue(Comparable[][] arr) {
        Comparable max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (compare(arr[i][j], max) > 0) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        GeneralizedMergeSortAnalyzer an1 = new GeneralizedMergeSortAnalyzer();

        Comparable[] arr1 = { "to", "being", "a", "cs", "major", "is", "very", "hard"};
        //Comparable[] arr = {5,6,8,9,2,34,0,97,1};
        System.out.println(Arrays.toString(an1.sort(arr1)));
    }
}
