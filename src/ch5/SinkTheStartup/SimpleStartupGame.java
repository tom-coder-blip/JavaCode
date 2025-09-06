// Pag3 110
package ch5.SinkTheStartup;

public class SimpleStartupGame {
    public static void main(String[] args) {
        int numOfGuesses = 0; // Track number of guesses made by the user
        GameHelper helper = new GameHelper(); // Helper to get user input
        SimpleStartup theStartup = new SimpleStartup(); // Create the startup object

        int randomNum = (int) (Math.random() * 5); // Generate random starting point (0–4)
        int[] locations = {randomNum, randomNum + 1, randomNum + 2}; // Set 3-cell location
        theStartup.setLocationCells(locations); // Assign location to the startup
        boolean isAlive = true; // Game continues while startup is alive

        while (isAlive) {
            int guess = helper.getUserInput("enter a number"); // Get user's guess
            String result = theStartup.checkYourself(guess); // Check guess against location
            numOfGuesses++; // Count the guess

            if (result.equals("kill")) { // If all cells are hit
                isAlive = false; // End the game
                System.out.println("You took " + numOfGuesses + " guesses"); // Show result
            }
        }
    }
}
