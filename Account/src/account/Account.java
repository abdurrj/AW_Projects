package account;

public class Account {

    private int balance = 0;
    final private int MAX_BALANCE = 100000;


    public String toString(){
        return "Current balance: " + balance;
    }

    public boolean deposit(int amount){
        if ((amount + balance)> MAX_BALANCE){
//            System.out.printf("Maximum balance allowed: %d%n", MAX_BALANCE);
//            System.out.printf("You may only deposit %d.%n", (MAX_BALANCE -balance));
            return false;
        }
        else if (amount >10000){
//            System.out.println("Maximum allowed deposit at the time: 10 000");
            return false;
        }
        else{
            balance += amount;
//            System.out.println("New balance: " + balance);
            return true;
        }
    }

    public boolean withdraw(int amount){
        if ((balance - amount)<0){
//            System.out.println("Insufficient balance.");
//            System.out.printf("You may only withdraw %d.%n", (balance));
            return false;
        }
        else{
//            balance -= amount;
//            System.out.println("New balance: " + balance);
            return true;
        }
    }


}
