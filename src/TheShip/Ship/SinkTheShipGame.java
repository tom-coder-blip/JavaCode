package TheShip.Ship;

import java.util.ArrayList;

public class SinkTheShipGame {
    public static void main(String[] args) {
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();
        Ship ship = new Ship();
        ArrayList<String> location = helper.generateShipLocation(3);
        ship.setLocationCells(location);

        System.out.println("Your goal is to sink the ship.");
        System.out.println("Try to sink it in the fewest number of guesses.");

        while (true) {
            String guess = helper.getUserInput("Enter a guess");
            String result = ship.checkYourGuess(guess);
            numOfGuesses++;
            System.out.println(result);

            if (result.equals("kill")) {
                System.out.println("You sunk the ship in " + numOfGuesses + " guesses!");
                break;
            }
        }
    }
}
