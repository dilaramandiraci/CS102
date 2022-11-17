package LAB6;

import java.util.Arrays;

public class MergeSortAnalyzer extends SortAnalyzer {

   int k = getK();
   @Override
   public Comparable[] sort(Comparable[] arr) {
      if (arr.length > 1 && !isSorted(arr)) {
         Comparable[] first = new Comparable[arr.length / 2];
         Comparable[] second = new Comparable[arr.length - first.length];
         // Copy the first half of a into first, the second half into second
         for (int i = 0; i < first.length; i++) {
            first[i] = arr[i];
         }
         for (int i = 0; i < second.length; i++) {
            second[i] = arr[first.length + i];
         }
         sort(first);
         sort(second);

         int iFirst = 0; // Next element to consider in the first array
         int iSecond = 0; // Next element to consider in the second array
         int j = 0; // Next open position in a

         // As long as neither iFirst nor iSecond is past the end, move
         // the smaller element into a
         while (iFirst < first.length && iSecond < second.length) {
            if (compare(first[iFirst], second[iSecond])<0) {
               arr[j] = first[iFirst];
               iFirst++;
            } else {
               arr[j] = second[iSecond];
               iSecond++;
            }
            j++;
         }

         // Note that only one of the two loops below copies entries
         // Copy any remaining entries of the first array
         while (iFirst < first.length) {
            arr[j] = first[iFirst];
            iFirst++;
            j++;
         }
         // Copy any remaining entries of the second half
         while (iSecond < second.length) {
            arr[j] = second[iSecond];
            iSecond++;
            j++;
         }
      }
      return arr;
   }

   public static void main(String[] args) {
      RandomArrayGenerator generator1 = new RandomArrayGenerator();
      MergeSortAnalyzer analyzer1 = new MergeSortAnalyzer();
      Comparable[] arr1 = generator1.generate(8);
      
      Comparable[] arr2 = {"to", "being", "a", "cs", "major", "is", "very", "hard"};
      System.out.println(Arrays.toString(arr2));
      System.out.println(analyzer1.isSorted(arr2));
      System.out.println(Arrays.toString(analyzer1.sort(arr2)));
      System.out.println(analyzer1.getNumberOfComparisons());

      System.out.println(Arrays.toString(arr1));
      System.out.println(Arrays.toString(analyzer1.sort(arr1)));
   }

}
