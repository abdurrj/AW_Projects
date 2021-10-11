public class Team {

    private String name;
    private int victories;

    public Team(String name, int victories) {
        this.name = name;
        this.victories = victories;
    }

    public String info() {
        String hasWonNeverWon = "has won";
        String timesOnce = " " + victories + " times.";
        if (victories==1){
            timesOnce = " once.";
        }
        else if (victories<1){
            hasWonNeverWon = "has never won";
            timesOnce = ".";
        }
        return name + " " + hasWonNeverWon + " Premier League" + timesOnce;
    }

    public String getName() {
        return name;
    }

    public int getVictories() {
        return victories;
    }

}
