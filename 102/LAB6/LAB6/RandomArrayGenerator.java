package LAB6;

import java.util.Arrays;
import java.util.Random;

public class RandomArrayGenerator implements ArrayGenerator {
    
    public Integer[] generate(Integer n)
    {
        Integer[] randomArray = new Integer[n];
        Random rand = new Random();

        for(int i = 1; i<=randomArray.length; i++)
        {
            int randomIndex = rand.nextInt(0,n);
            if(randomArray[randomIndex]==null)
            {
                randomArray[randomIndex] = i;
            }
            else
            {
                i--;
            }
        }

        return randomArray;
    }

    public static void main(String[] args) {
        RandomArrayGenerator g1 = new RandomArrayGenerator();
        System.out.println(Arrays.toString(g1.generate(8)));
    }
    
}
