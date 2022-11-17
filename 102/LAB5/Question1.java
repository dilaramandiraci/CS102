/**
 * This is the class for check if Sarah can eat her apples with 
 * eating 2 or 3 apples each day.
 * @author Dilara Mandıracı
 * @version final
 */
public class Question1 {

    /**
     * 
     * @param N total apples
     * @param k how much apple should have after a days
     * @param a days
     * @return
     */
    public static boolean appleQ(int N, int k, int a)
    {
        
        if(k==N && a==0)
        {
            return true;
        }
        else if(k>N)
        {
            return false;
        }
        else
        {
            return appleQ(N-2, k, a-1) || appleQ(N-3, k, a-1) ;
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println(appleQ(12, 4, 3));
    }
}
