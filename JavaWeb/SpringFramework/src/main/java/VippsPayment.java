public class VippsPayment implements Payment{

    @Override
    public void pay(int amount){
        System.out.println("From Vipps: " + amount);
    }
}
