import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayingCardDeck implements Comparable<PlayingCardDeck> {

    public static List<PlayingCard> createDeck(){

        List<PlayingCard> deckOfCards = new ArrayList<PlayingCard>();
        for (int i = 1; i<=4; i++){
            for (int j = 1; j<=13; j++){
                String cardSymbol = "";
                switch(i){
                    case 1 -> cardSymbol = "Heart";
                    case 2 -> cardSymbol = "Clubs";
                    case 3 -> cardSymbol = "Spades";
                    case 4 -> cardSymbol = "Diamonds";
                }
                PlayingCard p = new PlayingCard(j,cardSymbol,false);
                deckOfCards.add(p);
            }
        }

        return deckOfCards;
    }

    @Override
    public int compareTo(PlayingCardDeck o) {
        return 0;
    }
}
