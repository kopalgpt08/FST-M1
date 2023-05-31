package activities;

public class Bicycle implements BicycleOperations,BicycleParts{

    public int gears;
    public int speed;
    public Bicycle(int gears,int speed){
        this.gears=gears;
        this.speed=speed;
    }
    @Override
    public void applyBrake(int decrement) {
        this.speed=speed-decrement;
        System.out.println("Current speed:"+speed);
    }

    @Override
    public void speedUp(int increment) {
        this.speed=speed+increment;
        System.out.println("Current speed:"+speed);
    }
    public String bicycleDesc(){
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + speed);
    }
}
