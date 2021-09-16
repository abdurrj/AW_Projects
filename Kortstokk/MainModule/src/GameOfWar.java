import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameOfWar {
    static int counter =0;
    static List<PlayingCard> playerOneLoot = new ArrayList<>();
    static List<PlayingCard> playerTwoLoot = new ArrayList<>();
    static List<PlayingCard> tableCards = new ArrayList<>();
    static boolean hasWinner;


    public static void drawCard(List<PlayingCard> deck){
        while (counter<52) {
            PlayingCard p1 = deck.get(0);
            PlayingCard p2 = deck.get(1);
            System.out.println();
            System.out.println("Player 1: ");
            p1.printCardDetails();
            System.out.println();
            System.out.println("Player 2: ");
            p2.printCardDetails();
            int p1Card = p1.cardValue;
            int p2Card = p2.cardValue;

            if (p1Card == 1) {
                p1Card = 14;
            }
            if (p2Card == 1) {
                p2Card = 14;
            }

            System.out.println();
            if (p1Card > p2Card) {
                System.out.println("Player 1 wins the hand");
                playerOneLoot.add(p1);
                playerOneLoot.add(p2);
                if (tableCards.size() > 0) {
                    playerOneLoot.addAll(tableCards);
                    tableCards.clear();
                }
            } else if (p1Card < p2Card) {
                System.out.println("Player 2 wins the hand");
                playerTwoLoot.add(p1);
                playerTwoLoot.add(p2);
                if (tableCards.size() > 0) {
                    playerTwoLoot.addAll(tableCards);
                    tableCards.clear();
                }
            } else {
                tableCards.add(p1);
                tableCards.add(p2);
            }
            deck.remove(p1);
            deck.remove(p2);
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            counter += 2;
            if (counter==52){
                System.out.println("Game has ended");
                System.out.println(checkWinner());
                continue;
            }
            System.out.println("Draw next? ");
            if (scanner.next().startsWith("y")){

            }
            else{
                System.out.println("Game has ended");
                counter = 52;
                System.out.println(checkWinner());
                continue;

            }


        }

    }

    public static String checkWinner(){
        int p1LootSize = playerOneLoot.size();
        int p2LootSize = playerTwoLoot.size();
        if (p1LootSize == p2LootSize){
            return "It's a draw!";
        }
        else if (p1LootSize>p2LootSize){
            return "Player 1 wins! " + p1LootSize + " cards in total.";
        }
        else{
            return "Player 2 wins! " + p2LootSize + " cards in total.";
        }
    }

}
