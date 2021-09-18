package YatziGame;

public class Player {
    protected int[] playerScore = new int[19];
    protected String initials;

    public Player(String initials){
        if (initials.length()>3){
            System.out.println("Error creating player. Cant have more than three letters");
            return;
        }
        this.initials = initials;
    }

    public int[] getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int[] playerScore) {
        this.playerScore = playerScore;
    }

    public String getInitials() {
        return initials;
    }

}
