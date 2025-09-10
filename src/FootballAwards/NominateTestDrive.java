package FootballAwards;

import java.util.Scanner;

public class NominateTestDrive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueInput;

        System.out.println("Hi there Coach!");

        System.out.print("Would you like check if your striker qualifies for awards ceremony? (yes/no): ");
        continueInput = scanner.nextLine().trim().toLowerCase();

        while (continueInput.equals("yes")) {
            System.out.print("\nEnter the number of goals scored by the striker: ");
            int goals = scanner.nextInt();

            System.out.print("Enter the number of assists made by the striker: ");
            int assists = scanner.nextInt();

            System.out.print("Enter the number of team titles won by the striker: ");
            int titles = scanner.nextInt();

            Striker striker = new Striker();
            striker.setGoals(goals);
            striker.setAssists(assists);
            striker.setTeamTitles(titles);

            if (striker.isNominatedForAwards()) {
                System.out.println("Congrats! Your striker is nominated for the 2025 football awards ceremony!");
            } else {
                System.out.println("Unfortunately your striker is not nominated for the 2025 football awards ceremony.");
            }

            System.out.print("\nWould you like to evaluate another striker in your team? (yes/no): ");
            scanner.nextLine();
            continueInput = scanner.nextLine().trim().toLowerCase();
        }

        System.out.println("\nThanks for using the Football Awards Nomination Checker!");
        scanner.close();
    }
}

