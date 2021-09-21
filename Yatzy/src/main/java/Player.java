import ErrorHandling.IncorrectInitialsLengthException;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String playerInitials;
    List<Dice> throwingDice = new ArrayList<>();


    public Player(String playerInitials) throws IncorrectInitialsLengthException {
        if (playerInitials.length()<4) {
            this.playerInitials = playerInitials;
        }
        else{
            throw new IncorrectInitialsLengthException(playerInitials);
        }

    }

    public String getPlayerInitials() {
        return playerInitials;
    }

}
