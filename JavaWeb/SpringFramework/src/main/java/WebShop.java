public class WebShop{
    Payment pm;
//    PayPalPayment ppp = new PayPalPayment();
//    CardPayment cp = new CardPayment();
//    VippsPayment vp = new VippsPayment();

    public WebShop(Payment pm){
        this.pm = pm;
//        this.ppp = ppp;
//        this.cp = cp;
//        this.vp = vp;
    }



    public void checkout(int amount){
        pm.pay(amount);
//        if (payPalPayment != null){
//            payPalPayment.pay(amount);
//        }
//        else if (cardPayment != null){
//            cardPayment.pay(amount);
//        }
//        else if (vippsPayment != null){
//            vippsPayment.pay(amount);
//        }
    }
}
