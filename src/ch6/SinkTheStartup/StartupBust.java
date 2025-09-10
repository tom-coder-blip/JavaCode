package ch6.SinkTheStartup;

import java.util.ArrayList;

public class StartupBust {
    private GameHelper helper = new GameHelper(); //a tool that helps place startups on the grid and get user input.
    private ArrayList<Startup> startups = new ArrayList<Startup>(); //a list to store our 3 startup companies (the “targets”).
    private int numOfGuesses = 0; //keeps track of how many guesses the player made.

    //Create three startups and assign them random locations on the grid
    private void setUpGame() {
        // first make some Startups and give them locations
        Startup one = new Startup();
        one.setName("poniez");
        Startup two = new Startup();
        two.setName("hacqi");
        Startup three = new Startup();
        three.setName("cabista");
        startups.add(one);
        startups.add(two);
        startups.add(three);

        //instructions for the game
        System.out.println("Your goal is to sink three Startups.");
        System.out.println("poniez, hacqi, cabista");
        System.out.println("Try to sink them all in the fewest number of guesses");


        for (Startup startup : startups) {
            ArrayList<String> newLocation = helper.placeStartup(3); //Ask the helper to pick 3 spots on the grid (placeStartup(3)).
            startup.setLocationCells(newLocation);
        }
    }

    // Main game loop: keep asking for guesses until all startups are sunk
    private void startPlaying() {
        while (!startups.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    // Check the user's guess against all startups and print the result
    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for (Startup startupToTest : startups) {
            result = startupToTest.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                startups.remove(startupToTest);
                break;
            }
        }
        System.out.println(result);
    }

    // Display final message and performance summary based on number of guesses
    private void finishGame() {
        System.out.println("All Startups are dead! Your stock is now worthless");

        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }

    // Start the game by setting it up and beginning play
    public static void main(String[] args) {
        StartupBust game = new StartupBust();
        game.setUpGame();
        game.startPlaying();
    }
}


