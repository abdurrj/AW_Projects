package DiceExtra;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Dice regular6Dice = new Regular6Dice();
        System.out.println("regular6Dice.roll() = " + regular6Dice.roll());
        System.out.println("regular6Dice.roll() = " + regular6Dice.roll());
        System.out.println("regular6Dice.roll() = " + regular6Dice.roll());

        System.out.println("\n");

        List<Dice> manyDice = new ArrayList<>();
        for (int i = 0; i<100000; i++){
            if (i<50000){
                manyDice.add(new Regular6Dice());
            }
            else{
                manyDice.add(new Regular8Dice());
            }
        }

        List<Integer> manyThrows = new ArrayList<>();
        for (Dice d : manyDice){
            manyThrows.add(d.roll());
        }

        double sumCalc = 0.0;
        for (int i = 0; i<manyThrows.size(); i++){
            sumCalc+= manyThrows.get(i);
        }
        double average = sumCalc/manyThrows.size();
        System.out.println("Average = " + average);

    }

    // intt trix

}
