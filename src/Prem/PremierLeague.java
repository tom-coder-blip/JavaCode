package Prem;

import java.util.*;

public class PremierLeague {
    private List<Team> teams = new ArrayList<>();

    public void addTeam(String name) {
        teams.add(new Team(name));
    }

    public void simulateMatch(String team1Name, String team2Name, String result) {
        Team t1 = findTeam(team1Name);
        Team t2 = findTeam(team2Name);
        if (t1 == null || t2 == null) return;

        switch (result.toLowerCase()) {
            case "draw": t1.draw(); t2.draw(); break;
            case "team1": t1.win(); break;
            case "team2": t2.win(); break;
        }
    }

    public void showStandings() {
        teams.sort((a, b) -> b.getPoints() - a.getPoints());
        for (Team t : teams) {
            System.out.println(t.getName() + ": " + t.getPoints() + " pts");
        }
    }

    public boolean allTeamsPlayed() {
        for (Team t : teams) {
            if (t.getMatchesThisWeek() == 0) return false;
        }
        return true;
    }

    public void resetGameweek() {
        for (Team t : teams) {
            t.resetWeeklyMatches();
        }
    }

    private Team findTeam(String name) {
        for (Team t : teams) {
            if (t.getName().equalsIgnoreCase(name)) return t;
        }
        return null;
    }
}
