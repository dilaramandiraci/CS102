import java.util.Arrays;
/**
 * This is a game downloader class for Mike Wazowski, so that he can reach the
 * most efficient storage use based on metacritic scores.
 * @author Dilara Mandıracı
 * @version final
 */

public class Question2 {
    public static int[] gameDownloader(GameQ2[] games, int N)
    {
        int l = games.length-1;
        
        if(games.length == 0) 
        {
            return new int[0];
        }
        if(!hasSpace(games, N)) // if there is no any space for even one game
        {
            return new int[0];
        } 
        if(games.length == 1) // if there is only one game which passes the hasSpace part above, return that one only.
        {
            int[] result = {games[l].metacritic};
            return result;
        }
        //if the last game's gb less than N ve can check if it is worth to download.   
        // Otherwise we cannot check that one, so return new games array without it.
        if(games[l].gb > N) 
        {
            return gameDownloader(Arrays.copyOf(games, games.length-1),N);
        } 
        
        else
        {
            // checks if downloads this game, how much metacritic score they won. And checks if don't download that game how much earns.
            int ifDownloaded = games[l].metacritic + helperCalculator(Arrays.copyOf(games, games.length-1) , N-games[l].gb);
            int ifDont = helperCalculator(Arrays.copyOf(games, games.length-1) , N);

            if(ifDownloaded > ifDont)  
            {
                int[] arr1 = {games[l].metacritic};
                int[] arr2 = gameDownloader(Arrays.copyOf(games, games.length-1), N-games[l].gb);

                int[] array1and2 = new int[arr1.length + arr2.length];
                System.arraycopy(arr1, 0, array1and2, 0, arr1.length);
                System.arraycopy(arr2, 0, array1and2, arr1.length, arr2.length);

                return array1and2;
            } 
            else
            return gameDownloader(Arrays.copyOf(games, games.length-1),N);
        }
    }

    /**
     * This is the helper method to calculate returned int array from gameDownloader method.
     * @param remaininggames 
     * @param N storage
     * @return sumation of metacritic scores from downloading games.
     */
    public static int helperCalculator(GameQ2[] remaininggames , int N)
    {
        int sum = 0;
        int[] result = gameDownloader(remaininggames, N);
        for(int i = 0; i < result.length; i++)
        {
            sum+= result[i];
        }
        return sum;
    }

    /**
     * It checks if there is any space to download any game
     * @param games
     * @param N storage
     * @return
     */
    public static boolean hasSpace(GameQ2[] games , int N)
    {
        if(N==0){return false;}
        for(int i = 0; i<games.length ; i++)
        {
            if(games[i].gb < N)
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GameQ2[] games1 = { new GameQ2("gameA", 60, 75) , new GameQ2("gameB", 50, 85), new GameQ2("gameC", 200, 65),new GameQ2("gameC", 15, 100),new GameQ2("gameC", 40, 55)};
        System.out.println(Arrays.toString(gameDownloader(games1, 115)));
        GameQ2[] games2 = { new GameQ2("gameA", 45, 50) , new GameQ2("gameB", 10, 85), new GameQ2("gameC", 15, 45),new GameQ2("gameC", 20, 100),new GameQ2("gameC", 25, 6),new GameQ2("gameC", 100, 100)};
        System.out.println(Arrays.toString(gameDownloader(games2, 150)));
    }
    
}
