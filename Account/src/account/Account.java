package account;

/*
 * En konto kan ikke ha flere banker, men en bank kan ha flere kontoer
 * Account er derfor objektet vårt. Den har ingen metode som lar den kjøre.
 */

public class Account {

    // Variabler som ikke tilhører en "metode", men kontoen i seg selv
    // Alle metoder i objektet(kontoen) har tilgang til disse
    private int balance = 0;
    final private int MAX_BALANCE = 100000;

    /*
    Send et string objekt hvis metoden blir kalt på.
    dvs: String a =  account.toString()
    System.out.println(a) --> "Current balance: " + balance;
    Kan også skrive: System.out.println(account.toString());
    */
    public String toString(){
        return "Current balance: " + balance;
    }


    public boolean deposit(int amount){
        // Skal ikke kunne legge til penger hvis ny saldo er over maks tillat saldo
        if ((amount + balance)> MAX_BALANCE){
            return false;
        }
        // Skal heller ikke legge til hvis innskudd er mer enn 10000
        else if (amount >10000){
            return false;
        }
        else{
            balance += amount;
            return true;
        }
    }


    public boolean withdraw(int amount){
        // Skal ikke ha mulighet til å ta ut penger hvis det fører til at kontoen går i minus
        if ((balance - amount)<0){
            return false;
        }
        else{
            balance -= amount;
            return true;
        }
    }


}
