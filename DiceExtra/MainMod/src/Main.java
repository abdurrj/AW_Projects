import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Lager en regular6Dice, kaster den tre ganger
        Dice regular6Dice = new Regular6Dice();
        System.out.println("regular6Dice.roll() = " + regular6Dice.roll());
        System.out.println("regular6Dice.roll() = " + regular6Dice.roll());
        System.out.println("regular6Dice.roll() = " + regular6Dice.roll());

        System.out.println("\n");

        // Lager en liste som skal holde objekter av type Dice
        // Looper igjennom, første 50000 er vanlig regular6Dice, siste 50000 er regular8Dice
        List<Dice> manyDice = new ArrayList<>();
        for (int i = 0; i<100000; i++){
            if (i<50000){
                manyDice.add(new Regular6Dice());
            }
            else{
                manyDice.add(new Regular8Dice());
            }
        }

        // Tom liste for resultat av terningkast
        // Kaster alle 100 000 terninger, legger til tallet i lista
        List<Integer> manyThrows = new ArrayList<>();
        for (Dice d : manyDice){
            manyThrows.add(d.roll());
        }

        // Regner ut gjennomsnittsverdien over alle terningkast
        double sumCalc = 0.0;
        for (int i = 0; i<manyThrows.size(); i++){
            sumCalc+= manyThrows.get(i);
        }
        double average = sumCalc/manyThrows.size();
        System.out.println("Average = " + average);

    }

}
