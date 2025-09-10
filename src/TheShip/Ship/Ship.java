package TheShip.Ship;

import java.util.ArrayList;

//represents the ship and its location
public class Ship {
    private ArrayList<String> locationCells;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public String checkYourGuess(String userGuess) {
        String result = "miss";
        int index = locationCells.indexOf(userGuess);
        if (index >= 0) {
            locationCells.remove(index);
            result = locationCells.isEmpty() ? "kill" : "hit";
        }
        return result;
    }
}
