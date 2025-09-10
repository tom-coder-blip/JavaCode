package TheShip.Ship;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class GameHelper {
    private static final String ALPHABET = "abcdefg";
    private static final int GRID_LENGTH = 7;

    public String getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    public ArrayList<String> generateShipLocation(int size) {
        Random rand = new Random();
        int row = rand.nextInt(GRID_LENGTH);
        int startCol = rand.nextInt(GRID_LENGTH - size);
        ArrayList<String> location = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String cell = ALPHABET.charAt(startCol + i) + Integer.toString(row);
            location.add(cell);
        }
        return location;
    }
}
