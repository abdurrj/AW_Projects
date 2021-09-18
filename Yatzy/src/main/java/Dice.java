import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int numberOfFaces;
    int currentNumber;

    public Dice(int numberOfFaces){
        this.numberOfFaces = numberOfFaces;
    }

    public int roll(){
        currentNumber = ThreadLocalRandom.current().nextInt(1,numberOfFaces+1);
        return currentNumber;
    }

}
