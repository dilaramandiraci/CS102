import java.util.ArrayList;

public class Player {
    final double BOMB_RADIUS = 2.0;
    final double DAMAGE = 50.0;
    private int score = 0;

    public Player() {}
    
    public void attack(int x, int y, ArrayList<EnemyVehicle>enemies)
    {
        for(int i = 0; i<enemies.size(); i++)
        {
            int enemyX = (int) enemies.get(i).exactPoint.getX();
            int enemyY = (int) enemies.get(i).exactPoint.getY();
            // it is the mathematical expression that to find if a point is int he circular area (enemyX-x)^2 + (enemyY - y)^2 < BOMB_RADIUS^2
            int  a = (int ) Math.pow(Math.abs(enemyX-x), 2);
            int b = (int) Math.pow(Math.abs(enemyY-y), 2);
            int c = (int) Math.pow((int)BOMB_RADIUS, 2);

            if( a + b  < c)
            {
                enemies.get(i).takeDamage(DAMAGE);
            }
            
        }
    }
    public int getScore()
    {
        return this.score;
    }
    public void uptadeScore()
    {
        this.score += 1;
    }
    
}
