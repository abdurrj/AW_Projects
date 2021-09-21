
import org.junit.Assert;
import org.junit.Test;

public class AssessmentTest1Level1 {


    // Warm up (give this solution to the students)
    @Test
    public void warmUp1() {
        int result = Methods.addThree(5);
        Assert.assertEquals(8, result);
    }

    // Warm up (give this solution to the students)
    @Test
    public void warmUp2() {
        Assert.assertEquals(3, Methods.addThree(0));
        Assert.assertEquals(8, Methods.addThree(5));
        Assert.assertEquals(13, Methods.addThree(10));
    }

    @Test
    public void addFourAndThenMultiplyByThree() {
        Assert.assertEquals(12, Methods.addFourAndThenMultiplyByThree(0));
        Assert.assertEquals(15, Methods.addFourAndThenMultiplyByThree(1));
        Assert.assertEquals(27, Methods.addFourAndThenMultiplyByThree(5));
    }

    @Test
    public void maybeUppercaseAndDecorateText() {
        Assert.assertEquals("-:AAA:-", Methods.maybeUppercaseAndDecorateText("aaa", true, true));
        Assert.assertEquals("AAA", Methods.maybeUppercaseAndDecorateText("aaa", true, false));
        Assert.assertEquals("-:aaa:-", Methods.maybeUppercaseAndDecorateText("aaa", false, true));
        Assert.assertEquals("aaa", Methods.maybeUppercaseAndDecorateText("aaa", false, false));
    }

    @Test
    public void tellRelationToTheNumber100() {
        Assert.assertEquals("-5555 is a negative number", Methods.tellRelationToHundred(-5555));
        Assert.assertEquals("-1 is a negative number", Methods.tellRelationToHundred(-1));
        Assert.assertEquals("Add 8 to 92 and you get 100", Methods.tellRelationToHundred(92));
        Assert.assertEquals("Add 5 to 95 and you get 100", Methods.tellRelationToHundred(95));
        Assert.assertEquals("Add 0 to 100 and you get 100", Methods.tellRelationToHundred(100));
        Assert.assertEquals("101 is greater than 100", Methods.tellRelationToHundred(101));
        Assert.assertEquals("4444 is greater than 100", Methods.tellRelationToHundred(4444));
    }

    @Test
    public void aPetRoborovskiHamster() {
        Hamster hamster = new Hamster("Nemo", true, HamsterSpecie.ROBOROVSKI);
        String result = hamster.greet();
        Assert.assertEquals("Nemo is a pet ROBOROVSKI hamster.", result);
    }

    @Test
    public void aWildSyrianHamster() {
        Hamster hamster = new Hamster("Kernel", false, HamsterSpecie.SYRIAN);
        String result = hamster.greet();
        Assert.assertEquals("Kernel is a wild SYRIAN hamster.", result);
    }

}