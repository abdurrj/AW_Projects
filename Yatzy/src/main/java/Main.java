import ErrorHandling.IncorrectInitialsLengthException;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IncorrectInitialsLengthException {

        List<Player> playerList = new ArrayList<>();

        Player arj = new Player("ARJ");
        Player ai = new Player("AI");

        playerList.add(arj);
        playerList.add(ai);

        for (Player p : playerList){
            for (int i = 0; i<6; i++){
                p.throwingDice.add(new Dice(6));
            }
        }

        for (int i = 0; i<10; i++) {
            for (Player p : playerList) {
                String res = "roll result: ";
                for (Dice d : p.throwingDice) {
                    d.roll();
                    res = res + " [" + d.currentNumber + "]";
                }
                System.out.println(res);
            }
        }

    }
}

/*
* for (int i = 0; i<throwingDice; i++){
*   if (throwingDice.get(i).rollDice){
*
*       }
*   }
* */