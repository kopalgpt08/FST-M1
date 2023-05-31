package activities;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Plane {
    private List<String> passengers;
    private int maxPassenger;
    public Date lastTimeTookOf;
    public Date lastTimeLanded;
    public Plane(int maxPassenger){
        this.maxPassenger=maxPassenger;
        this.passengers=new ArrayList<>();
    }
    public void onboard(String passengers){
        this.passengers.add(passengers);
    }
    public Date takeOff() {
        this.lastTimeTookOf = new Date();
        return lastTimeTookOf;
    }

    public void land() {
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }
    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }

    public List<String> getPassengers() {
        return passengers;
    }
}
