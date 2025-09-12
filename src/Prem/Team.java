package Prem;

// Team.java
public class Team {
    private String name;
    private int points;
    private int matchesThisWeek;

    public Team(String name) {
        this.name = name;
        this.points = 0;
        this.matchesThisWeek = 0;
    }

    public void win() { points += 3; }
    public void draw() { points += 1; }
    public void played() { matchesThisWeek++; }

    public String getName() { return name; }
    public int getPoints() { return points; }
    public int getMatchesThisWeek() { return matchesThisWeek; }
    public void resetWeeklyMatches() { matchesThisWeek = 0; }
}
