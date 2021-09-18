import java.util.concurrent.ThreadLocalRandom;

public class Regular6Dice extends Dice{

    // Siden terningen er helt vanlig, men med bestemt antall sider,
    // Trenger vi ikke noe spesiell input. tar bare og skriver direkte antall sider
    public Regular6Dice(){
        super(6);
    }

    @Override
    public int roll() {
                                        // Inklusiv første tall, eksklusiv siste tall, derfor +1
        return ThreadLocalRandom.current().nextInt(1,numberOfSides+1);
    }
}
