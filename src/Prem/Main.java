package Prem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PremierLeague league = new PremierLeague();
        Scanner sc = new Scanner(System.in);
        String inMatchweek;

        league.addTeam("Arsenal");
        league.addTeam("Manchester City");
        league.addTeam("Liverpool");
        league.addTeam("Man United");
        league.addTeam("Spurs");
        league.addTeam("Chelsea");

        System.out.print("Start/continue gameweek (yes/no): ");
        inMatchweek = sc.nextLine().trim().toLowerCase();

        while (inMatchweek.equals("yes")) {
            System.out.println("Simulate a match:");
            System.out.print("Team 1: ");
            String t1 = sc.nextLine();
            System.out.print("Team 2: ");
            String t2 = sc.nextLine();
            System.out.print("Result (team1/team2/draw): ");
            String result = sc.nextLine();

            league.simulateMatch(t1, t2, result);
            System.out.println("\nCurrent Standings:");
            league.showStandings();

            System.out.print("continue gameweek (yes/no): ");
            inMatchweek = sc.nextLine().trim().toLowerCase();
        }

        System.out.println("End of matchweek");
    }
}
