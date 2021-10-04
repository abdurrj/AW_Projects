public class CardPayment implements Payment{

    @Override
    public void pay(int amount){
        System.out.println("From Card: " + amount);
    }
}
