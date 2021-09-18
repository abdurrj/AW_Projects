package YatziGame;

// Et generelt objekt "Terning", derfor abstract
public abstract class Dice {
    int numberOfSides;

    public Dice(int numberOfSides){
        if (numberOfSides<1){
            this.numberOfSides = 1;
        }
        else if (numberOfSides>20){
            this.numberOfSides = 20;
        }
        else {
            this.numberOfSides = numberOfSides;
        }
    }

    // Hvis vi ønsker å hente informasjon om hvor mange sider terningen har
    public int getNumberOfSides() {
        return numberOfSides;
    }

    // Legger inn en abstract fuksjon roll
    // Så vi kan kalle på den på alle terninger, uavhengig av type
    // enten det er vanlig terning eller jukseterning
    public abstract int roll();
}