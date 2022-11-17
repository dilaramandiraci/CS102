/**
 * This is the main class for Question 4. Whic also uses MazeC and Portal class to run and solve the array.
 * @author Dilara Mandıracı
 * @version final
 */
public class Question4 {
    public static void main (String[] args)
   {
      int [][] grid1 = { {1, 0, 0, 0, 0, 0}, 
                         {1, 1, 1, 0, 0, 0}, 
                         {0, 0, 0, 0, 1, 1}};
      int[][] grid2 = { {1, 1, 0, 1, 1, 1},
                         {0, 0, 0, 0, 0, 1},
                         {0, 0, 0, 1, 0, 0},
                         {0, 0, 0, 0, 0, 0},
                         {1, 1, 0, 0, 1, 1}};
      Portal p1 = new Portal(1, 2, 2, 4);   
      Portal[] portals2 = {p1};  
      
      Portal p2 = new Portal(0, 1, 0, 3);
      Portal p3 = new Portal(1, 5, 4, 0);
      Portal p4 = new Portal(4, 1, 4, 4);

      Portal[] portals1 = {p2,p3,p4};
      MazeC labyrinth = new MazeC(grid2, portals1);
      
      System.out.println (labyrinth);

      if (labyrinth.traverse (0, 0))
         System.out.println ("The maze was successfully traversed!");
      else
         System.out.println ("There is no possible path.");

      System.out.println (labyrinth);
   }
    
}
