/**
 * This is the game class for Question 2
 * @author Dilara Mandıracı
 * @version final
 */
public class GameQ2 implements Comparable<GameQ2>{
    String name;
    int gb;
    int metacritic;

    public GameQ2(String aName, int gb, int metacritic)
    {
        this.name = aName;
        this.gb = gb;
        this.metacritic = metacritic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }

    public int getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(int metacritic) {
        this.metacritic = metacritic;
    }

    @Override
    public int compareTo(GameQ2 o) {
        if(this.metacritic>o.metacritic)
        {
            return -1;
        }
        else if(this.metacritic<o.metacritic)
        {
            return 1;
        }
        else
        {
            return 0;
        }
        
    }

    
}
