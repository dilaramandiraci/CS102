package LAB6;

import java.util.Arrays;

public class DecreasingArrayGenerator implements ArrayGenerator{

    @Override
    public Integer[] generate(Integer n) {
        Integer[] DecreasingArray = new Integer[n];

        for(int i = DecreasingArray.length; i>=1; i--)
        {
            DecreasingArray[DecreasingArray.length-i] = i;
        }

        return DecreasingArray;
    }

    public static void main(String[] args) {
        DecreasingArrayGenerator g1 = new DecreasingArrayGenerator();
        System.out.println(Arrays.toString(g1.generate(8)));
    }
    
    
}
