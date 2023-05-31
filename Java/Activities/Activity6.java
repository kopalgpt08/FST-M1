package activities;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane=new Plane(10);
        plane.onboard("P1");
        plane.onboard("P2");
        plane.onboard("P3");
        System.out.println("Plane took off at:"+plane.takeOff());
        System.out.println("People on the plane:");
        plane.getPassengers();
        Thread.sleep(5000);
        plane.land();
        System.out.println("Plane landed:");
        plane.getLastTimeLanded();
        System.out.println("People on the plane:");
        plane.getPassengers();
    }
}
