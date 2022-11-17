package LAB6;

import java.util.Arrays;
import java.util.Random;

public class IncreasingArrayGenerator implements ArrayGenerator {

    @Override
    public Integer[] generate(Integer n) {
        Integer[] IncreasingArray = new Integer[n];

        for(int i = 1; i<=IncreasingArray.length; i++)
        {
            IncreasingArray[i-1] = i;
        }

        return IncreasingArray;
    }

    public static void main(String[] args) {
        IncreasingArrayGenerator g1 = new IncreasingArrayGenerator();
        System.out.println(Arrays.toString(g1.generate(8)));
    }
    
}
