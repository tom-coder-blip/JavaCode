package ch4.ExercisePg88;

public class ClockTestDrive {
    public static void main(String[] args) {
        Clock c = new Clock(); //object
        c.setTime("07h30");
        String tod = c.getTime();
        System.out.println("time: "+tod);
    }
}
