import ErrorHandling.IncorrectInitialsLengthException;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void PrintsPlayerInitials() throws IncorrectInitialsLengthException {
        Player player = new Player("BCD");
        Assert.assertEquals("BCD", player.getPlayerInitials());

    }

    @Test(expected = Exception.class)
    public void NoPlayerNameWithMoreThanThreeCharacters() throws IncorrectInitialsLengthException{
        Player player = new Player("ABCD");
    }
}
