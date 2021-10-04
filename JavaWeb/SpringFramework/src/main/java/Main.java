public class Main {

    public static void main(String[] args) {
        Payment ppp = new PayPalPayment();
        Payment cp = new CardPayment();
        Payment vp = new VippsPayment();
        WebShop ws = new WebShop(vp);
        ws.checkout(200);

    }


}
