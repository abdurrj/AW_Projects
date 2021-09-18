package account;
import java.util.Scanner;


public class TestATM {


    public static void main(String[] args) {


        Account account = new Account();
        Scanner sc = new Scanner(System.in);
        boolean runProgram = true;


        // While loop så ATM systemet ikke avslutter, med mindre brukeren ønsker det
        while (runProgram){

            printMenu(); // Caller metoden for å printe menyen
            String userSelection = sc.nextLine();

            // Fortsetter å spørre bruker om input hvis input ikke er tall fra 1 til 4
            while(!userSelection.matches("[1-4]")){
                System.out.print("Selection: ");
                userSelection = sc.nextLine();
            }

            System.out.println();


            // Switch case for å se om brukeren tastet valg fra
            switch(userSelection){
                case "1"->{
                    // Kjør metode som henter input fra brukeren, men samtidig sjekker om den er gyldig
                    // Gjort til metode siden den brukes mer enn én gang
                    int amount = checkAmountInput();

                    if (account.deposit(amount)){
                        System.out.println("Deposited: " + amount);
                    }
                    else{
                        System.out.println("Could not deposit " + amount);
                    }
                }
                case "2" ->{
                    int amount = checkAmountInput();
                    if (account.withdraw(amount)){
                        System.out.println("Withdrew: " + amount);
                    }
                    else {
                        System.out.println("Could not withdraw " + amount);
                    }
                }
                case "3" ->{
                    System.out.println(account);
                    System.out.println();
                }
                case "4" ->{
                    System.out.println("Terminating program.....");

                    // avslutter while(runProgram) loop
                    runProgram = false;
                }
                default -> System.out.println();
            }
        }
    }

    // Strengt tatt ikke nødvendig hvis vi antar at brukeren alltid har gyldig input
    // Men alltid grei øvelse
    private static int checkAmountInput(){
        Scanner sc = new Scanner(System.in);
        String selection = sc.next();
        // Fortsetter å spørre brukeren så lenge input ikke er gyldig
        while(!selection.matches("[0-9]+")){
            System.out.print("Amount: ");
            selection = sc.next();
        }

        return Integer.parseInt(selection);
    }


    // Egen metode for å skrive ut meny, gjør det litt mer ryddig
    private static void printMenu(){
        System.out.println("Menu");
        System.out.println("-----------------");
        System.out.println("1) Deposit");
        System.out.println("2) Withdraw");
        System.out.println("3) Check balance");
        System.out.println("4) Quit");
    }
}
