//Page 112
package ch6.SinkTheStartup;

import java.util.*;

public class GameHelper {
    private static final String ALPHABET = "abcdefg"; //columns go from a → g.
    private static final int GRID_LENGTH = 7; //grid is 7 cells wide.
    private static final int GRID_SIZE = 49; //7×7 grid (like Battleship board).
    private static final int MAX_ATTEMPTS = 200; //tries up to 200 times to find a place.
    static final int HORIZONTAL_INCREMENT = 1; // moving right.
    static final int VERTICAL_INCREMENT = GRID_LENGTH; // moving down.

    private final int[] grid = new int[GRID_SIZE]; //grid = array of 49 numbers (0 = empty, 1 = occupied).
    private final Random random = new Random(); //to pick random positions.
    private int startupCount = 0; //keeps track of how many startups are already placed (helps alternate direction).

    // Prompt the user and return their input as a lowercase string
    public String getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    } // end getUserInput

    // Try to place a startup of given size on the grid without overlapping
    public ArrayList<String> placeStartup(int startupSize) {
        // holds index to grid (0 - 48)
        int[] startupCoords = new int[startupSize]; // current candidate co-ordinates
        int attempts = 0; // current attempts counter
        boolean success = false; // flag = found a good location?
        startupCount++; // nth Startup to place
        int increment = getIncrement(); // alternate vert & horiz alignment

        while (!success & attempts++ < MAX_ATTEMPTS) { // main search loop
            int location = random.nextInt(GRID_SIZE); // get random starting point
            for (int i = 0; i < startupCoords.length; i++) { // create array of proposed coords
                startupCoords[i] = location; // put current location in array
                location += increment; // calculate the next location
            }
            // System.out.println("Trying: " + Arrays.toString(startupCoords));
            if (startupFits(startupCoords, increment)) { // startup fits on the grid?
                success = coordsAvailable(startupCoords); // ...and locations aren't taken?
            }
        } // end while

        savePositionToGrid(startupCoords); // coords passed checks, save
        ArrayList<String> alphaCells = convertCoordsToAlphaFormat(startupCoords);
        System.out.println("Placed startup at: " + alphaCells);
        // System.out.println("Placed at: "+ alphaCells);
        return alphaCells;
    } // end placeStartup

    // Check if the startup fits within grid boundaries
    private boolean startupFits(int[] startupCoords, int increment) {
        int finalLocation = startupCoords[startupCoords.length - 1];
        if (increment == HORIZONTAL_INCREMENT) {
            // check end is on same row as start
            return calcRowFromIndex(startupCoords[0]) == calcRowFromIndex(finalLocation);
        } else {
            return finalLocation < GRID_SIZE; // check end isn't off the bottom
        }
    } // end startupFits

    // Check if the proposed grid positions are available (not already used)
    private boolean coordsAvailable(int[] startupCoords) {
        for (int coord : startupCoords) { // check all potential positions
            if (grid[coord] != 0) { // this position already taken
                // System.out.println("position: " + coord + " already taken.");
                return false; // NO success
            }
        }
        return true; // there were no clashes, yay!
    } // end coordsAvailable

    // Mark the grid positions as occupied
    private void savePositionToGrid(int[] startupCoords) {
        for (int index : startupCoords) {
            grid[index] = 1; // mark grid position as 'used'
        }
    } // end savePositionToGrid

    // Convert numeric grid positions to alphanumeric format (e.g., "a3")
    private ArrayList<String> convertCoordsToAlphaFormat(int[] startupCoords) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        for (int index : startupCoords) { // for each grid coordinate
            String alphaCoords = getAlphaCoordsFromIndex(index); // turn it into an "a0" style
            alphaCells.add(alphaCoords); // add to a list
        }
        return alphaCells; // return the "a0"-style coords
    } // end convertCoordsToAlphaFormat

    // Convert a single grid index to alphanumeric format
    private String getAlphaCoordsFromIndex(int index) {
        int row = calcRowFromIndex(index); // get row value
        int column = index % GRID_LENGTH; // get numeric column value
        String letter = ALPHABET.substring(column, column + 1); // convert to letter
        return letter + row;
    } // end getAlphaCoordsFromIndex

    // Calculate the row number from a grid index
    private int calcRowFromIndex(int index) {
        return index / GRID_LENGTH;
    } // end calcRowFromIndex

    // Alternate between horizontal and vertical placement for startups
    private int getIncrement() {
        if (startupCount % 2 == 0) { // if EVEN Startup
            return HORIZONTAL_INCREMENT; // place horizontally
        } else { // else ODD
            return VERTICAL_INCREMENT; // place vertically
        }
    } // end getIncrement
} // end class


