import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game implements Difficulty {
    protected int difficulty;
    final int STARTING_DISTANCE = 20;
    private ArrayList<EnemyVehicle> enemies;
    private Player aPlayer;
    private int passedBorder = 0;
    private final int MAX_NO_OF_PASSING_ENEMIES = 5;
    private GamePlotter plotter;
    int minX = 0;
    int maxX = 0;

    public Game(int difficulty)
    {
        aPlayer = new Player();
        enemies = new ArrayList<EnemyVehicle>();
        
        this.difficulty = difficulty;

        int numberOfEnemies = 0;
        if(difficulty ==1)
        {
            numberOfEnemies = 2;
            minX = 0;
            maxX = 5;
        }
        if(difficulty ==2)
        {
            numberOfEnemies =4;
            minX = 0;
            maxX = 10;
        }
        if(difficulty == 3)
        {
            numberOfEnemies = 6;
            minX = 0;
            maxX = 15;
        }
        for(int i = 0; i<numberOfEnemies; i++)
        {
            EnemyVehicle aVehicle = getNewRandomVehicle();
            enemies.add(aVehicle);
        }
        plotter = new GamePlotter(this);
    }

    @Override
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public int getDifficulty() {
        return this.difficulty;
    }

    public EnemyVehicle getNewRandomVehicle()
    {
        Random rand = new Random();
        int chance = rand.nextInt(0,2);
        if(chance == 0)
        {
            return new Tank(minX, maxX, STARTING_DISTANCE);
        }
        else
        {
            return new Helicopter(minX, maxX, STARTING_DISTANCE);
        }
    }

    public void play()
    {
        Scanner in = new Scanner(System.in);
        while(passedBorder < MAX_NO_OF_PASSING_ENEMIES)
        {
            printGameState();
            System.out.println("enter x y coordinates to bomb: x y");
            int givenX = in.nextInt();
            int givenY = in.nextInt();
            aPlayer.attack(givenX, givenY, enemies);
            enemiesTurn();
        }
    }
    public void enemiesTurn()
    {
        for(int i = 0; i<enemies.size(); i++)
        {
            if(enemies.get(i).isDestroyed())
            {
                enemies.remove(i);
                EnemyVehicle added = getNewRandomVehicle();
                enemies.add(added);
                aPlayer.uptadeScore();
            }
        }
        for(EnemyVehicle each : enemies)
        {
            each.move();
            if(each.getDistanceToBorder() <= 0)
            {
                each = getNewRandomVehicle();
                passedBorder++;
            }
        }
    }
    public void printGameState()
    {
        for(EnemyVehicle each : enemies)
        {
            System.out.println(each.toString());
        }
        System.out.println("Current Score: " + aPlayer.getScore());
        System.out.println("Enemy numbers passed border: " + passedBorder);
        plotter.plot();
    }

    public ArrayList<EnemyVehicle> getEnemies() {
        return enemies;
    }
    
}
