package YatziGame;

import YatziGame.Dice;

import java.util.concurrent.ThreadLocalRandom;

public class Regular8Dice extends Dice {

    public Regular8Dice(){
        super(8);
    }

    @Override
    public int roll() {
        int[] weightedOptions = new int[]{1,numberOfSides,numberOfSides,numberOfSides,numberOfSides};
        // tilfeldig velge et av alternativene ovenfra
        int rollResult = ThreadLocalRandom.current().nextInt(0,5);
        return weightedOptions[rollResult];
    }
}
