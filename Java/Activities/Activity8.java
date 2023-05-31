package activities;

public class Activity8 {
    public static void main(String[] args){
    try{
        Activity8.exceptionTest("console");
        Activity8.exceptionTest(null);
        Activity8.exceptionTest("Wont execute");
    }catch(CustomException ce){
        System.out.println("Inside catch block"+ce.getMessage());
    }
    }
    static void exceptionTest(String str) throws CustomException {
        if(str==null){
            throw new CustomException("Sting value is null");
        }
        else {
            System.out.println(str);
        }
    }
}
