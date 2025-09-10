package Prem;

// Team.java
public class Team {
    private String name;
    private int points;

    public Team(String name) {
        this.name = name;
        this.points = 0;
    }

    public void win() { points += 3; }
    public void draw() { points += 1; }
    public String getName() { return name; }
    public int getPoints() { return points; }
}
