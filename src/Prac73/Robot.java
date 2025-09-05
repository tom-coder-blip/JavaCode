package Prac73;

public class Robot {
    int energyLevel;

    void performTask() {
        if (energyLevel > 70) {
            System.out.println("Robot is building a spaceship!");
        } else if (energyLevel > 30) {
            System.out.println("Robot is assembling furniture.");
        } else {
            System.out.println("Robot is recharging...");
        }
    }
}
