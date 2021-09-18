package YatziGame;

import java.util.ArrayList;
import java.util.List;


public class YatziGame {
    int numOfPlayers;
    List<Dice> listOfDice;
    List<Dice> tempListOfDice;
    List<Dice> throwingDice;
    String[] playerInitial;

    public YatziGame(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public void makeGameBoard(){
        List<String> boardRows = new ArrayList<>();
        String row01 = "|                |"; boardRows.add(row01);
        String row02 = "| Enere          |"; boardRows.add(row02);
        String row03 = "| Toere          |"; boardRows.add(row03);
        String row04 = "| Treere         |"; boardRows.add(row04);
        String row05 = "| Firere         |"; boardRows.add(row05);
        String row06 = "| Femmere        |"; boardRows.add(row06);
        String row07 = "| Seksere        |"; boardRows.add(row07);
        String row08 = "| Sum            |"; boardRows.add(row08);
        String row09 = "| Bonus          |"; boardRows.add(row09);
        String row10 = "| 1 par          |"; boardRows.add(row10);
        String row11 = "| 2 par          |"; boardRows.add(row11);
        String row12 = "| 3 like         |"; boardRows.add(row12);
        String row13 = "| 4 like         |"; boardRows.add(row13);
        String row14 = "| Liten straight |"; boardRows.add(row14);
        String row15 = "| Stor straight  |"; boardRows.add(row15);
        String row16 = "| Hus            |"; boardRows.add(row16);
        String row17 = "| Sjanse         |"; boardRows.add(row17);
        String row18 = "| Yatzi          |"; boardRows.add(row18);
        String row19 = "| Totalsum       |"; boardRows.add(row19);

        for (int i = 0; i<numOfPlayers; i++){

        }
    }
}
