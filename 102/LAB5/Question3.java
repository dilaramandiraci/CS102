/**
 * This is the class to find minimum edit to convert one string from another string.
 * @author Dilara Mandıracı
 * @version final
 */
public class Question3 {

    public static int minOperation(String A, String B)
    {
        if(A.equals(B)) //if they are equal return 0 edits
        {
            return 0;
        }

        //if one of them's lenght is 0, then we need other's lenght times edit to create that string.
        if(A.length() == 0) 
        {
            return B.length();
        }
        if(B.length() == 0)
        {
            return A.length();
        }

        //if their last characters are same, then we don't need to edit anything. So, just return that words without their last chars.
        if (A.charAt(A.length() - 1) == B.charAt(B.length() - 1))
        {
            return minOperation(deleteLastChar(A), deleteLastChar(B));
        }

        //else we will check which move is more efficent than the others. After deciding call the efficient one and add 1 for each move. 
        else
        {
            return 
                    1 + Math.min(minOperation(deleteLastChar(A), B), 
                            Math.min(minOperation(A, deleteLastChar(B)),
                                minOperation(deleteLastChar(A), deleteLastChar(B)))); 
        }
    }

    public static String deleteLastChar(String x)
    {
        return x.substring(0, x.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(minOperation("exclamation", "excavation"));
        System.out.println(minOperation("sunday", "saturday"));
        System.out.println(minOperation("inquire", "ensure"));
        System.out.println(minOperation("car", "race"));
        System.out.println(minOperation("man", "men"));
        System.out.println(minOperation("plane", "plane"));
        System.out.println(minOperation("excuse", "excuseme"));
    }
    
}
