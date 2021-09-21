
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class AssessmentTest1Level2 {


    @Test
    public void aPetHamsterWhoDontLikeFood() {
        Hamster hamster = new Hamster("Maximilian", true, HamsterSpecie.CAMPBELL);
        String result = hamster.description();
        Assert.assertEquals("Maximilian is a pet CAMPBELL hamster. Maximilian doesn't like any food.", result);
    }

    @Test
    public void aPetHamsterWhoLikesThreeTypesOfFood() {
        Hamster hamster = new Hamster("Dexter", true, HamsterSpecie.SYRIAN);
        hamster.setLikesFood(new ArrayList<String>(Arrays.asList("seeds", "fruits", "insects")));
        String result = hamster.description();
        Assert.assertEquals("Dexter is a pet SYRIAN hamster. Dexter likes 3 types of food.", result);
    }

    @Test
    public void aPetHamsterWhoLikesTwoTypesOfFood() {
        Hamster hamster = new Hamster("Chiquita", true, HamsterSpecie.ROBOROVSKI);
        hamster.setLikesFood(new ArrayList<String>(Arrays.asList("fruits", "insects")));
        String result = hamster.description();
        Assert.assertEquals("Chiquita is a pet ROBOROVSKI hamster. Chiquita likes 2 types of food.", result);
    }

    @Test
    public void aWildHamsterWhoLikesOneTypeOfFood() {
        Hamster hamster = new Hamster("Goldilocks", false, HamsterSpecie.WINTER_WHITE);
        hamster.setLikesFood(new ArrayList<String>(Arrays.asList("insects")));
        String result = hamster.description();
        Assert.assertEquals("Goldilocks is a wild WINTER_WHITE hamster. Goldilocks likes 1 type of food.", result);
    }

    // Use a new constructor so the following test will pass
    // The new constructor should give some default data for the hamster (a winterwhite wild hamster who likes insects)
    @Test
    public void aHamsterCreatedWithAlternativeConstructor() {
        Burrow burrow = new Burrow(20.55, 10.77);

        Hamster hamster = new Hamster("Jojo", burrow);

        String position = hamster.getBurrowPosition();
        Assert.assertEquals("Jojo has a burrow at longitude 10.77 and latitude 20.55", position);

        Assert.assertFalse(hamster.isPet());

        Assert.assertEquals("Jojo is a wild WINTER_WHITE hamster. Jojo likes 1 type of food.", hamster.description());

        Assert.assertEquals(1, hamster.getLikesFood().size());
        Assert.assertEquals("insects", hamster.getLikesFood().get(0));

        // Now Jojo don't have a burrow anymore
        hamster.setBurrow(null);

        Assert.assertEquals("Jojo doesn't have a burrow", hamster.getBurrowPosition());
    }


}