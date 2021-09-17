import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Palindrome {

    public boolean isPalindrome(String a, String b){
        List<String> aList = Arrays.asList(a.toLowerCase().split(""));
        List<String> bList = Arrays.asList(b.toLowerCase().split(""));
        Collections.sort(aList);
        Collections.sort(bList);
        return aList.equals(bList);
    }
}
