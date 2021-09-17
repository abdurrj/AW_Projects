import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator sut;

    @Before
    public void before(){
        sut = new Calculator();
    }

    @Test
    public void addsTwoNumbers(){
        assertEquals(8, sut.add(3, 5));
    }

    @Test
    public void doesNotAddWithNegativeNumbers(){

        assertEquals(-1, sut.add(5,-1));
    }

    @Test
    public void subtractsTwoNumbers() throws Exception{
        assertEquals(2,sut.subtract(5,3));
    }

    @Test(expected = java.lang.Exception.class)
    public void doesNotSubtractWithNegativeNumber() throws Exception{
        int sumSub = sut.subtract(-1, 4);
    }

}
