
public class Tank extends EnemyVehicle {

    public Tank(int minX, int maxX, int y) {
        super(minX, maxX, y);
    }
    @Override
    public void takeDamage(double damage) {
        this.life -= damage/2;
    }

    @Override
    public String getType() {
        return "" + getClass();
    }

    public String toString()
    {
        return "A Tank is at location " + this.getExactPoint() + ". It has " + this.life + " left.";
    }
    
}
