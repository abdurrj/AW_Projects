import java.util.ArrayList;
import java.util.List;

public class Hamster {
    String name;
    boolean isPet;
    HamsterSpecie hamsterSpecie;
    Burrow burrow;
    List<String> likesFood;

    public Hamster(String name, boolean isPet, HamsterSpecie hamsterSpecie) {
        this.name = name;
        this.isPet = isPet;
        this.hamsterSpecie = hamsterSpecie;
    }

    public Hamster(String name, Burrow burrow) {
        // Informasjon fra bruker
        this.name = name;
        this.burrow = burrow;

        // Normalverdier. Trenger ikke sette noe for isPet, da boolean har standardverdi false;
        hamsterSpecie = HamsterSpecie.WINTER_WHITE;
        likesFood = new ArrayList<>() ; likesFood.add("insects");
    }

    public String greet() {
        String status = " is a wild ";
        if (isPet){
            status = " is a pet ";
        }
        return name + status + hamsterSpecie + " hamster.";
    }

    public String description() {
        String greet = greet();
        String description = "";
        if (likesFood == null){
            description = name + " doesn't like any food.";
        }
        else {
            String typeOrTypes = "";
            // Rette på gramatikk, entall / flertall
            if (likesFood.size()==1){
                typeOrTypes = "type";
            }
            else{
                typeOrTypes = "types";
            }
            description = name + " likes " + likesFood.size() + " " + typeOrTypes + " of food.";
        }
        return greet + " " + description;
    }

    public String getBurrowPosition() {
        if (burrow == null){
            return name + " doesn't have a burrow";
        }
        /* Burrow variablene er ikke private, og vi kan derfor bruke burrow.lat and burrow.lng
        * for å nå de. Har valgt å fikse på getLat() og getLng() så de ikke returnerer fast verdi på 0.0
        * og bruke de i metoden tilfelle det bestemmes for å endre på synligheten til variablene
        */
        return name + " has a burrow at longitude " + burrow.getLng() + " and latitude " + burrow.getLat();

    }

    public void setBurrow(Burrow burrow) {
        this.burrow = burrow;
    }

    public boolean isPet() {
        // Bør returnere hamsterens data, ikke false
        return isPet;
    }

    public void setLikesFood(List<String> likesFood) {
        this.likesFood = likesFood;
    }

    public List<String> getLikesFood() {
        return likesFood;
    }
}
