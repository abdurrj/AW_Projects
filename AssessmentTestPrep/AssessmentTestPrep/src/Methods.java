public class Methods {


    public static String mostWins(Team teamOne, Team teamTwo) {
        if (teamOne.getVictories()>teamTwo.getVictories()){
            return teamOne.getName() + " has won Premier League more than " + teamTwo.getName();
        }
        else if (teamOne.getVictories()<teamTwo.getVictories()){
            return teamOne.getName() + " has won Premier League less than " + teamTwo.getName();
        }
        else{
            return "Both teams have won Premier League equal amount of times";
        }
    }

    public static int calculatePayoutOrProfit(int wagerAmount, int odds, boolean calculateNetProfit) {
        int payout = wagerAmount*odds;
        if(calculateNetProfit){
            return payout - wagerAmount;
        }
        return payout;
    }

    public static int numberOfMatchesPrTeam(int numberOfTeamsInLeague) {
        return (numberOfTeamsInLeague-1)*2;
    }

    public static int numberOfMatchesTotalInASeason(int numberOfTeamsInLeague) {
        return numberOfTeamsInLeague*(numberOfTeamsInLeague-1);
    }

    public static int calculatePoints(int wins, int draws, int losses) {
        return wins*3 + draws;
    }

    public static int calculatePlayersLeft(int players, int amountOfRedCards) {
        return players-amountOfRedCards;
    }
}
