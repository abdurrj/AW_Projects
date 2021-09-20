import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int numberOfFaces;
    int currentNumber;
    boolean rollDice = true;

    public Dice(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public int roll() {
        if (rollDice) {
            currentNumber = ThreadLocalRandom.current().nextInt(1, numberOfFaces + 1);
        }
        setRollDice(false);
        return currentNumber;
    }

    public void setRollDice(boolean rollDice){
        this.rollDice = rollDice;
    }

}