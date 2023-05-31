package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        // Adding element to HashSet
        hs.add("E1");
        hs.add("E2");
        hs.add("E3");
        hs.add("E4");
        hs.add("E5");
        hs.add("E6");

        //Print HashSet
        System.out.println("Original HashSet: " + hs);
        //Print size of HashSet
        System.out.println("Size of HashSet: " + hs.size());

        //Remove element
        System.out.println("Removing E4 from HashSet: " + hs.remove("E4"));
        //Remove element that is not present
        if(hs.remove("E7")) {
            System.out.println("E7 removed from the Set");
        } else {
            System.out.println("E7 is not present in the Set");
        }

        //Search for element
        System.out.println("Checking if E2 is present: " + hs.contains("E2"));
        //Print updated HashSet
        System.out.println("Updated HashSet: " + hs);
    }
}

