import com.payment.Payment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("WebShop")
public class WebShop{
    Payment pm;


    public WebShop(Payment pm) {
        this.pm = pm;
    }


    public void checkout(int amount){
        pm.pay(amount);
    }
}
