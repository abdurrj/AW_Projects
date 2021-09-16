package account;
import java.util.Scanner;


public class TestATM {


    public static void main(String[] args) {

        Account account = new Account();
        Scanner sc = new Scanner(System.in);
        while (true){
            String selection = "0";
            printMenu();
            do{
                System.out.print("Selection: ");
                selection = sc.nextLine();
            }while(!selection.matches("[0-9]"));
            System.out.println();

            int userSelection = Integer.parseInt(selection);
            if (userSelection == 1){ // Deposit
                int amount = checkAmountInput();
                if (account.deposit(amount)){
                    System.out.println("Deposited: " + amount);
                }
                else{
                    System.out.println("Could not deposit " + amount);
                }
            }
            else if (userSelection == 2){

                int amount = checkAmountInput();
                if (account.withdraw(amount)){
                    System.out.println("Withdrew: " + amount);
                }
                else {
                    System.out.println("Could not withdraw " + amount);
                }
            }
            else if (userSelection == 3){
                System.out.println(account.toString());
                System.out.println();
            }
            else if (userSelection == 4){
                System.out.println("Terminating program.....");
                break;
            }
            else{
                System.out.println();
            }
        }
    }

    private static int checkAmountInput(){
        Scanner sc = new Scanner(System.in);
        String selection = "0";
        do{
            System.out.print("Amount: ");
            selection = sc.next();
        }while(!selection.matches("[0-9]+"));
        return Integer.parseInt(selection);
    }


    private static void printMenu(){
        System.out.println("Menu");
        System.out.println("-----------------");
        System.out.println("1) Deposit");
        System.out.println("2) Withdraw");
        System.out.println("3) Check balance");
        System.out.println("4) Quit");
    }
}
