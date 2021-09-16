package DiceExtra;

public abstract class Dice {
    int numberOfSides;

    public Dice(int numberOfSides){
        if (numberOfSides<1){
            this.numberOfSides = 1;
        }
        else if (numberOfSides>20){
            this.numberOfSides = 20;
        }
        else {
            this.numberOfSides = numberOfSides;
        }
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public abstract int roll();
}