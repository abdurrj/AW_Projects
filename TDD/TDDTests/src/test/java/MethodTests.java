import org.junit.Assert;
import org.junit.Test;

public class MethodTests {

    // Methods.addThree is already implemented
    @Test
    public void warmup() {
        Assert.assertEquals(8, Methods.addThree(5));
    }

    @Test
    public void multiplyByTen() {
        Assert.assertEquals(50, Methods.multiplyByTen(5));
        Assert.assertEquals(10, Methods.multiplyByTen(1));
        Assert.assertEquals(100, Methods.multiplyByTen(10));
    }
    
    @Test
    public void maybeTrimText() {
        Assert.assertEquals("lorem lipsum", Methods.maybeTrimText(" lorem lipsum ", true));
        Assert.assertEquals("lorem lipsum", Methods.maybeTrimText("  lorem lipsum   ", true));
        Assert.assertEquals(" lorem lipsum ", Methods.maybeTrimText(" lorem lipsum ", false));
    }

    @Test
    public void compareNumbers() {
        Assert.assertEquals("1 is less than 3", Methods.compareNumbers(1,3));
        Assert.assertEquals("3 is equal to 3", Methods.compareNumbers(3,3));
        Assert.assertEquals("3 is greater than 1", Methods.compareNumbers(3,1));
    }

}
