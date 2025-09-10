package FootballAwards;

public class Striker {

    private int goals;
    private int assists;
    private int teamTitles;

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setTeamTitles(int teamTitles) {
        this.teamTitles = teamTitles;
    }

    public boolean isNominatedForAwards() {
        return (goals >= 25 && assists >= 10) || (teamTitles >= 3 && goals >= 15);
    }
}
