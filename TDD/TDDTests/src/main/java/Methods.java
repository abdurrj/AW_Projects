public class Methods {

    public static int addThree(int n) {
        return n + 3;
    }

    public static int multiplyByTen(int n) {
        return n*10;
    }

    public static String maybeTrimText(String text, boolean trimWhitespace) {
        if (trimWhitespace){
            return text.trim();
        }
        return text;
    }

    public static String compareNumbers(int a, int b) {
        if (a<b){
            return a + " is less than " + b;
        }
        else if (a>b){
            return a + " is greater than " + b;
        }
        return a + " is equal to " + b;
    }
}
