package activities;

public class Activity1{
    public static void main(String args[]) {
        Car honda = new Car();
        honda.make=2014;
        honda.color="Black";
        honda.transmission="Manual";
        honda.displayCharacteristics();
        honda.accelarate();
        honda.brake();
    }

}
