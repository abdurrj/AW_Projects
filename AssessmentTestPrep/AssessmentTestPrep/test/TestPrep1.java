import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestPrep1 {

    private League league;

    @Before
    public void setup() {
        league = new League();
    }

    @Test
    public void howManyPlayersAreLeft() {
        // For every red card awarded, a player has to leave the game!
        assertEquals(11, Methods.calculatePlayersLeft(11, 0));
        assertEquals(5, Methods.calculatePlayersLeft(11, 6));
        assertEquals(6, Methods.calculatePlayersLeft(7, 1));
    }

    @Test
    public void howManyMatchesArePlayedPerTeamInOneSeason() {
        // Every team plays against every other team twice (one home match, and one away match)
        assertEquals(38, Methods.numberOfMatchesPrTeam(20));
        assertEquals(30, Methods.numberOfMatchesPrTeam(16));
        assertEquals(22, Methods.numberOfMatchesPrTeam(12));
    }

    @Test
    public void howManyMatchesArePlayedInTotalInOneSeason() {
        // Every team meets another team every round, how many matches can be played in one round?
        // And how many rounds before each team has played every other team twice?
        assertEquals(380, Methods.numberOfMatchesTotalInASeason(20));
        assertEquals(240, Methods.numberOfMatchesTotalInASeason(16));
        assertEquals(132, Methods.numberOfMatchesTotalInASeason(12));
    }

    @Test
    public void calculatePoints() {
        // Every game won is awarded 3 points, every draw is awarded 1 point. Losses are not awarded any points.
        assertEquals(17, Methods.calculatePoints(5, 2, 3));
        assertEquals(16, Methods.calculatePoints(3, 7, 0));
        assertEquals(35, Methods.calculatePoints(10, 5, 1));
    }

    @Test
    public void calculatePayoutOrProfit() {
        // Calculate potential payout or profit for a given given wager and odds
        assertEquals(15000, Methods.calculatePayoutOrProfit(5000, 3/1, false));
        assertEquals(35000, Methods.calculatePayoutOrProfit(5000, 7/1, false));
        assertEquals(142500, Methods.calculatePayoutOrProfit(2500, 58/1, true));
        assertEquals(24000, Methods.calculatePayoutOrProfit(1500, 17/1, true));
    }

    @Test
    public void compareTeams() {
        assertEquals("Chelsea has won Premier League more than Arsenal", Methods.mostWins(new Team("Chelsea", 5), new Team("Arsenal", 3)));
        assertEquals("Manchester United has won Premier League more than Arsenal", Methods.mostWins(new Team("Manchester United", 13), new Team("Arsenal", 3)));
        assertEquals("Tottenham Hotspur has won Premier League less than Arsenal", Methods.mostWins(new Team("Tottenham Hotspur", 0), new Team("Arsenal", 3)));
    }

    @Test
    public void showTeamInformation() {
        List<Team> teams = league.getTeams();

        assertEquals("Chelsea has won Premier League 5 times.", teams.get(0).info());
        assertEquals("Arsenal has won Premier League 3 times.", teams.get(2).info());
        assertEquals("Manchester United has won Premier League 13 times.", teams.get(3).info());
        assertEquals("Tottenham Hotspur has never won Premier League.", teams.get(4).info());
        assertEquals("Blackburn Rovers has won Premier League once.", teams.get(5).info());
        assertEquals("Leicester City has won Premier League once.", teams.get(6).info());
    }

    @Test
    public void printTeamsInOrder() {
        List<Team> teams = league.teamsSortedByVictories();

        assertEquals("Manchester United", teams.get(0).getName());
        assertEquals("Chelsea", teams.get(1).getName());
        assertEquals("Tottenham Hotspur", teams.get(teams.size() - 1).getName());
    }
}
