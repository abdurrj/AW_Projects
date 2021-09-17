import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {

    @Test
    public void returnsTrue(){
        Palindrome palindrome = new Palindrome();
        Assert.assertTrue(palindrome.isPalindrome("Alle", "Ella"));
    }
}
