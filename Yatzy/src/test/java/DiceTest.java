import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    @Test
    public void rollsRandomNumberFromOneToSix(){
        int valueCheck = 1;
        Dice dice = new Dice(6);

        for (int i = 0; i<10000; i++) {
            int randomNumber = dice.roll();
            if (randomNumber < 0 || randomNumber > 7) {
                valueCheck = -1;
                break;
            }
        }
        Assert.assertEquals(1, valueCheck);
    }
}
