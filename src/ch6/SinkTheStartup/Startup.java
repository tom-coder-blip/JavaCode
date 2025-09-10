package ch6.SinkTheStartup;

import java.util.ArrayList;

public class Startup {
    private ArrayList<String> locationCells; //the grid spots where this startup is placed. Example: [“a3”, “a4”, “a5”].
    private String name; //the startup’s name (e.g., "poniez").
    private String userInput; //stores the latest guess the player typed.

    // Set the startup's location on the grid
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    // Set the name of the startup
    public void setName(String n) {
        name = n;
    }

    // Check if user's guess hits, misses, or kills this startup
    public String checkYourself(String userInput) {
        this.userInput = userInput;
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + " : ( ");
            } else {
                result = "hit";
            } // end ifexplain
        } // end outer if
        return result;
    } // end method
} // close class

