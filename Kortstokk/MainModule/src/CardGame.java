import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class CardGame {

    static String gameRules =
            """
            Both player draws the top card.
            Player with highest value card wins matchup and takes both cards.
            2 is the lowest value, Ace is the highest value.
            If both cards are of equal value. They remain on the table, Whoever wins the next matchup,
            takes all the cards on the table.
            """;

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);


        while(true){
            drawMenu();
            String menuChoice = sc.next();
            while (!inputIsValid(menuChoice, "[1-3]")){
                System.out.print("Try again: ");
                menuChoice = sc.next();
            }
            System.out.println();
            switch (menuChoice){
                case "1" -> {
                    List<PlayingCard> cardDeck = PlayingCardDeck.createDeck();
                    System.out.println();
                    System.out.println("Retrieving new deck....");
                    Thread.sleep(2000);
                    System.out.println("Shuffling deck....");
                    Thread.sleep(2000);
                    Collections.shuffle(cardDeck);
                    GameOfWar.drawCard(cardDeck);

                }
                case "2" -> System.out.println(gameRules);
                case "3" -> {
                    System.out.println("Terminating....");
                    return;
                }
            }
        }

    }

    public static boolean inputIsValid(String input, String expression){
        if (input.matches(expression)){
            return true;
        }
        return false;
    }

    public static void drawMenu(){
        System.out.println("--------------------");
        System.out.println("1) Play game");
        System.out.println("2) View rules");
        System.out.println("3) Quit");
        System.out.println("--------------------");
        System.out.print("Selection: ");
    }




}
