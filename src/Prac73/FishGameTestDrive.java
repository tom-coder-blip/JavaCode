package Prac73;

// Main class to test the CatchTheFish game
public class FishGameTestDrive {
    public static void main(String[] args) {
        Fish fish = new Fish();                      // Create a fish object
        int[] swimPath = {5, 6, 7};                  // Set its swimming path
        fish.setSwimPath(swimPath);                  // Assign path to the fish

        int userGuess = 6;                           // Simulate a user guess
        String result = fish.checkGuess(userGuess);  // Check the guess

        String testResult = "failed";                // Default test result
        if (result.equals("caught")) {               // If guess was a catch
            testResult = "passed";                   // Mark test as passed
        }
        System.out.println(testResult);              // Print the test result
    }
}

// Class that handles fish logic
class Fish {
    private int[] swimPath;                          // Stores fish's path
    private int catchCount = 0;                      // Tracks number of catches

    public void setSwimPath(int[] path) {            // Set swimming path
        swimPath = path;
    }

    public String checkGuess(int guess) {            // Check user's guess
        String result = "miss";                      // Default result
        for (int spot : swimPath) {                  // Loop through path
            if (guess == spot) {                     // If guess matches a spot
                result = "caught";                   // It's a catch
                catchCount++;                        // Increase catch count
                break;                               // Exit loop after catch
            }
        }

        if (catchCount == swimPath.length) {         // If all spots are caught
            result = "fish caught completely!";      // Fish is fully caught
        }

        System.out.println(result);                  // Show result
        return result;                               // Return result
    }
}