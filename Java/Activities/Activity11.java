package activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer,String> hm=new HashMap<Integer, String>();
        hm.put(1,"Blue");
        hm.put(2,"Red");
        hm.put(3,"Yellow");
        hm.put(4,"White");
        hm.put(5,"Black");

        //Print the list
        System.out.println("The Original map: " + hm);

        //Remove the color
        hm.remove(2);
        System.out.println("Updated map is:"+hm);
        // Check if green exists
        if(hm.containsValue("Green")) {
            System.out.println("Green exists in the Map");
        } else {
            System.out.println("Green does not exist in the Map");
        }

        // Print the size of the Map
        System.out.println("Size Map is: " + hm.size());
    }

}

