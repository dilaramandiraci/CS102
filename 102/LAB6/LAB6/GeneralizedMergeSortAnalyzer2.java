package LAB6;

import java.util.Arrays;

public class GeneralizedMergeSortAnalyzer2 extends SortAnalyzer {

    int k = getK();

    @Override
    public Comparable[] sort(Comparable[] arr) {
        
        int n = arr.length;

        if(n<k && !isSorted(arr))
        {
            n = arr.length;
            for (int i = 1; i < n; ++i) {
                Comparable key = arr[i];
                int j = i - 1;

                while (j >= 0 && compare(arr[j], key)>0) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            } 
        } 

        if (arr.length > 1 && !isSorted(arr) && n>=k) 
        {
            int regular = 1;
            int p = 0;

            Comparable[][] partitions = new Comparable[k][];
            for (int i = 0; i < k - 1; i++) {
                Comparable[] temp = new Comparable[regular];

                for (int j = 0; j < regular; j++) {
                    temp[j] = arr[p];
                    p++;
                }
                partitions[i] = temp;
            }

            Comparable[] temp = new Comparable[n - (regular * (k - 1))];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = arr[p];
                p++;
            }
            sort(temp);
            partitions[k - 1] = temp;

            int[] indexes = new int[partitions.length];
            int minIndex = 0;
            int j = 0;
            

            while(j<arr.length) 
            {
                Comparable min = maxValue(partitions);
                minIndex = 0;

                for (int i = 0; i < partitions.length; i++) {

                    if(indexes[i] < partitions[i].length)
                    {
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
        }
        return arr;
    }

    public Comparable maxValue (Comparable[][] arr)
    {
        Comparable max = arr[0][0];
        for(int i = 0; i < arr.length; i++){ 
            for(int j = 0; j < arr[i].length; j++){ 
                if(compare(arr[i][j], max)>0){ 
                    max = arr[i][j]; 
                } 
            } 
        } 
        return max;
    }

    public static void main(String[] args) {
        GeneralizedMergeSortAnalyzer2 an1 = new GeneralizedMergeSortAnalyzer2();

        Comparable[] arr = {"to", "being", "a", "cs", "major", "is", "very", "hard"};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(an1.sort(arr)));
    }
}