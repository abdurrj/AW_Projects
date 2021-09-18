import java.util.Scanner;


public class CalcEasy {

    public static void main(String[] args) {

        // Lage Scanner og kalle den input. Ta en linje med input og splitte den på " " --> Array med input
        // velg verdi nr 2 fra array [tall, operator, tall] som operator
        Scanner input = new Scanner(System.in);
        String[] inputArray = input.nextLine().split(" ");
        String operator = inputArray[1];

        // Hvis operator ikke er + eller - eller * eller /, send ut feil og avslutt
        if (!(operator.equals("+")||operator.equals("-")||operator.equals("*")||operator.equals("/"))){
            System.out.println("Invalid input");
            return;
        }

        // Sjekk operator og utfør utregning.
        // Bruker Integer.parseInt() ford tallene foreløpig er en String, og vi må konvertere til int
        if (operator.equals("+")){
            System.out.println(Integer.parseInt(inputArray[0]) + Integer.parseInt(inputArray[2]));
        }
        else if (operator.equals("-")){
            System.out.println(Integer.parseInt(inputArray[0]) - Integer.parseInt(inputArray[2]));
        }
        else if (operator.equals("*")){
            System.out.println(Integer.parseInt(inputArray[0]) * Integer.parseInt(inputArray[2]));
        }
        else{
            System.out.println(Integer.parseInt(inputArray[0]) / Integer.parseInt(inputArray[2]));
        }

    }
}
