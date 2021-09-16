public class PlayingCard {

    protected int cardValue;
    protected final String cardSymbol;
    protected final boolean isVisible;

    public PlayingCard(int cardValue, String cardSymbol, boolean isVisible) {
        this.cardValue = cardValue;
        this.cardSymbol = cardSymbol;
        this.isVisible = isVisible;
    }

    public void printCardDetails(){
        String cardValuePrint = String.valueOf(cardValue);
        if (1  == cardValue ) {
            cardValuePrint = "Ace";
        }
        else if (11  ==cardValue ) {
            cardValuePrint = "Jack";
        }
        else if (12  ==cardValue ) {
            cardValuePrint = "Queen";
        }
        else if (13  ==cardValue ) {
            cardValuePrint = "King";
        }
        System.out.println(cardValuePrint + " of " + cardSymbol);

    }

}
