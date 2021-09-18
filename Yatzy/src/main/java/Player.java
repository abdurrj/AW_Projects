import ErrorHandling.IncorrectInitialsLengthException;

import java.util.List;
import java.util.Scanner;

public class Player {
    String playerInitials;
    List<Dice> throwingDice;
    List<Dice> keepingDice;


    public Player(String playerInitials) throws IncorrectInitialsLengthException{
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

    public List<Dice> getKeepingDice(){
        return keepingDice;
    }
    public void setKeepingDice(String input, List<Dice> throwingDice){
        String[] splitInput = input.split(" ");
        for (int i = 0; i<splitInput.length; i++){
            int diceNr = Integer.parseInt(splitInput[i]);
            keepingDice.add(throwingDice.get(diceNr));
        }
        throwingDice.remove(keepingDice);
    }
}
