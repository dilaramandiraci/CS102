import java.awt.Point;
import java.util.Random;

public abstract class EnemyVehicle implements Movable , Destructible{
    /* protected int xDirection;
    protected int yDirection; */
    protected final int BASE_SPEED = 3;
    protected Point exactPoint;
    protected double life = 100;
    

    public EnemyVehicle(int minX, int maxX, int y)
    {
        Random rand = new Random();
        int choosen = rand.nextInt(minX, maxX);
        /* this.xDirection = choosen;
        this.yDirection = y; */
        this.exactPoint = new Point(choosen,y);
    }

    public int getDistanceToBorder()
    {
        return (int) exactPoint.getY();
    }

    public abstract String getType();

    @Override
    public Point getLocation() {
        return exactPoint;
    }

    @Override
    public void move() {
        exactPoint.y -= BASE_SPEED;
        /* if(!isDestroyed())
        {
            exactPoint.setLocation(this.xDirection, this.yDirection);
        } */
    }

    @Override
    public boolean isDestroyed() {
        if(life<=0.0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void takeDamage(double damage) {
        this.life -= damage;
    }

    public int getxDirection() {
        return (int) exactPoint.getX();
    }

/*     public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    } */

    public int getyDirection() {
        return (int) exactPoint.getY();
    }
/* 
    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    } */

    public int getBASE_SPEED() {
        return BASE_SPEED;
    }

    public String getExactPoint() {
        return "( " + exactPoint.getX() + " , " + exactPoint.getY() + " )";
    }

    public void setExactPoint(Point exactPoint) {
        this.exactPoint = exactPoint;
    }

}
