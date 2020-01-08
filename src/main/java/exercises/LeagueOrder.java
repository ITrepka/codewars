package exercises;

import java.util.*;
import java.util.stream.Collectors;

public class LeagueOrder {
    public static int[] computeRanks(int number, int[][] games) {
        List<Team> teams = createTeamsList(number);
        Arrays.stream(games).forEach(game -> handleSingleMatch(teams, game));
        return createTable(teams);
    }

    private static List<Team> createTeamsList(int number) {
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            teams.add(new Team(i));
        }
        return teams;
    }

    private static int[] createTable(List<Team> teams) {
        setPositions(teams);
        return teams.stream().sorted(Comparator.comparingInt(Team::getId)).map(Team::getLeaguePosition).mapToInt(pos -> pos).toArray();
    }

    private static void setPositions(List<Team> teams) {
        List<Team> teamsAfterSort = sortByPointsAndGoalsDiff(teams);
        int position = 1;
        teamsAfterSort.get(0).setLeaguePosition(1);
        for (int i = 1; i < teamsAfterSort.size(); i++) {
            position = isTheSamePlace(teamsAfterSort.get(i), teamsAfterSort.get(i - 1)) ? position : i + 1;
            teamsAfterSort.get(i).setLeaguePosition(position);
        }
    }

    private static boolean isTheSamePlace(Team team, Team team2) {
        return getGoalDifferential(team) == getGoalDifferential(team2)
                && team.getPoints() == team2.getPoints() && team.getGoalsScored() == team2.getGoalsScored();
    }

    private static List<Team> sortByPointsAndGoalsDiff(List<Team> teams) {
        return teams.stream()
                .sorted((team1, team2) -> team2.getGoalsScored() - team1.getGoalsScored())
                .sorted((team1, team2) -> getGoalDifferential(team2) - getGoalDifferential(team1))
                .sorted((team1, team2) -> team2.getPoints() - team1.getPoints())
                .collect(Collectors.toList());
    }

    private static int getGoalDifferential(Team team) {
        return team.getGoalsScored() - team.getGoalsLost();
    }

    private static void handleSingleMatch(List<Team> teams, int[] game) {
        Team teamHome = teams.get(game[0]);
        Team teamAway = teams.get(game[1]);
        handleMatchResult(teamHome, game[2], game[3]);
        handleMatchResult(teamAway, game[3], game[2]);
    }

    private static void handleMatchResult(Team team, int goalsScored, int goalsLost) {
        team.setGoalsScored(team.getGoalsScored() + goalsScored);
        team.setGoalsLost(team.getGoalsLost() + goalsLost);
        team.setPoints(team.getPoints() + (goalsScored > goalsLost ? 2 : goalsScored == goalsLost ? 1 : 0));
    }
}

class Team {
    private int id;
    private int points;
    private int goalsScored;
    private int goalsLost;
    private int leaguePosition;

    public Team(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsLost() {
        return goalsLost;
    }

    public void setGoalsLost(int goalsLost) {
        this.goalsLost = goalsLost;
    }

    public int getLeaguePosition() {
        return leaguePosition;
    }

    public void setLeaguePosition(int leaguePosition) {
        this.leaguePosition = leaguePosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", points=" + points +
                ", goalsScored=" + goalsScored +
                ", goalsLost=" + goalsLost +
                ", leaguePosition=" + leaguePosition +
                '}';
    }
}
