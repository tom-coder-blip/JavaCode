package Prac73;


public class RobotTestDrive {
    public static void main(String[] args) {
        Robot alpha = new Robot();
        alpha.energyLevel = 90;
        Robot beta = new Robot();
        beta.energyLevel = 40;
        Robot gamma = new Robot();
        gamma.energyLevel = 10;

        alpha.performTask();
        beta.performTask();
        gamma.performTask();

    }
}
