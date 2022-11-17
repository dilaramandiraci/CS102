public class Helicopter extends EnemyVehicle{
    private int speedOfHeli = super.BASE_SPEED;

    public Helicopter(int minX, int maxX, int y) {
        super(minX, maxX, y);
    }
    @Override
    public void move() {
        this.exactPoint.y -= speedOfHeli;
        speedOfHeli ++;
        //exactPoint.setLocation(this.xDirection, this.yDirection);
    }

    @Override
    public String getType() {
        return "" + getClass();
    }
    
    public String toString()
    {
        return "A Helicopter is at location " + this.getExactPoint() + ". It has " + this.life + " left.";
    }
}
