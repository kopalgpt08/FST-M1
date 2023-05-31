package activities;

import java.util.Scanner;

public class Activity3 {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("Enter age in seconds:");
        int age= sc.nextInt();
        double mercuryPeriod = 0.2408467;
        double venusPeriod = 0.61519726;
        double earthPeriod = 31557600;
        double marsPeriod = 1.8808158;
        double jupiterPeriod = 11.862615;
        double saturnPeriod = 29.447498;
        double uranusPeriod = 84.016846;
        double neptunePeriod = 164.79132;


        System.out.println("Age on Mercury: " + String.format("%.2f",age / earthPeriod / mercuryPeriod));
        System.out.println("Age on Venus: " + String.format("%.2f",age / earthPeriod / venusPeriod));
        System.out.println("Age on Earth: " + String.format("%.2f",age / earthPeriod));
        System.out.println("Age on Mars: " + String.format("%.2f",age / earthPeriod / marsPeriod));
        System.out.println("Age on Jupiter: " + String.format("%.2f",age / earthPeriod / jupiterPeriod));
        System.out.println("Age on Saturn: " + String.format("%.2f",age / earthPeriod / saturnPeriod));
        System.out.println("Age on Uranus: " + String.format("%.2f",age / earthPeriod / uranusPeriod));
        System.out.println("Age on Neptune: " + String.format("%.2f",age / earthPeriod / neptunePeriod));
    }
}
