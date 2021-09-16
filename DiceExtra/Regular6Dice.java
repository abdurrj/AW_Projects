package DiceExtra;

import java.util.concurrent.ThreadLocalRandom;

public class Regular6Dice extends Dice{

    public Regular6Dice(){
        super(6);
    }

    @Override
    public int roll() {
        int rollResult = ThreadLocalRandom.current().nextInt(1,7);
        return rollResult;
    }
}
