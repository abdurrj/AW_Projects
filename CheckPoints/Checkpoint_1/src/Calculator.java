import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter expression you want calculated. Separate numbers and operators with spacebar");
        System.out.println("Valid operators are + - * /");
        System.out.println("Enter quit to terminate.");

        while(true) { // Looper hele kalkulatoren
            System.out.print("Expression: ");
            String[] userInput = input.nextLine().split(" ");
            if (userInput[0].equals("quit")){
                System.out.println("Terminating program....");
                return;
            }
            // Spør bruker om ny input hvis input er for kort eller er partall
            while (userInput.length <= 1 || (userInput.length % 2 == 0)) {
                System.out.print("Expression: ");
                userInput = input.nextLine().split(" ");
            }

            if (isValid(userInput)){
                calcSum(userInput);
            }
            System.out.println("---------------");
        }
    }

    static boolean isValid(String[] inputArray){
        for (int i = 0; i < inputArray.length; i++) {
            String check = inputArray[i];
            if (i % 2 != 0) {  // Sjekker oddetallsposisjoner ( operatorer )
                if (!(check.equals("+") || check.equals("-") || check.equals("*") || check.equals("/"))) {
                    System.out.printf("%s is not a valid operator. ", check);
                    return false;
                }
            }
            else if (i % 2 == 0) { // Sjekker partallsposisjoner ( nummere )
                if (!check.matches("-?[0-9]+")) {
                    /*
                    Regex utrykket betyr:
                    -? --> - kan være med, men må ikke.
                    [0-9] --> alt mellom er gyldig
                    + --> Bakrest, så den godtar flersifrede tall
                    dvs at den heller sjekker det sammenhengende objektet, og så lenge alt er tall godtar den det
                     */
                    System.out.printf("%s is not a valid number. ", check);
                    return false;
                }
            }
        }
        return true;
    }

    static void calcSum(String[] inputArray){
        int sum = Integer.parseInt(inputArray[0]);

        // Start gange og dele
        for (int i = 1; i<=inputArray.length-2; i+=2){
            String operator = inputArray[i];
            int value1 = Integer.parseInt(inputArray[i-1]);
            int value2 = Integer.parseInt(inputArray[i+1]);

            // Midlertidig sum. Tømmes hver gang
            String multiSum = "";
            if (operator.equals("*")||operator.equals("/")) {
                if (operator.equals("*")) {
                    multiSum = String.valueOf(value1 * value2);
                } else {
                    if (value2 == 0) {
                        System.out.println("Error: Trying to divide by 0. Cancelling");
                        return;
                    }
                    multiSum = String.valueOf(value1 / value2);
                }
                inputArray[i - 1] = "0";
                inputArray[i] = "+";
                inputArray[i + 1] = multiSum;
            }
        } // Ferdig med ganging og deling
        /*
        Visualisering på hva som har skjedd:
        inputArray før gange/dele = {2,+,3,*,3,+,1}
        inputArray etter gange/dele = {2,+,0,+,9,+,1}
         */
        // Sjekker ikke lenger for * og - siden det ble gjort over
        System.out.println(Arrays.toString(inputArray));
        for (int i = 0; i < inputArray.length - 2; i += 2) {
            String operator = inputArray[i + 1];
            if (operator.equals("+")) {
                sum += Integer.parseInt(inputArray[i + 2]);
            } else if (operator.equals("-")) {
                sum -= Integer.parseInt(inputArray[i + 2]);
            }
        }
        System.out.println("Sum = " + sum);
    }
}