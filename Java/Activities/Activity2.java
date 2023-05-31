package activities;

import java.util.Arrays;

public class Activity2 {

    public static void main(String[] args) {
        int activity2_arr[]={10, 77, 10, 54, -11, 10,10};
        int sum=0;
        System.out.println("initial Array:"+ Arrays.toString(activity2_arr));

        for(int n:activity2_arr){
            if(n==10){
                sum=sum+n;
            }
        }
        if(sum==30){
            System.out.println("Sum is equal to 30");
        }
        else
            System.out.println("Sum is not equal to 30");
    }
}
