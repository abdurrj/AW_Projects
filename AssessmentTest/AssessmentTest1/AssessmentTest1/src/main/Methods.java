
public class Methods {
    public static int addThree(int n) {
        return n+3;
    }

    public static int addFourAndThenMultiplyByThree(int n) {
        n+=4;
        n*=3;
        return n;
    }

    public static String maybeUppercaseAndDecorateText(String s, boolean uppercase, boolean decorate) {
        if (uppercase){
            s = s.toUpperCase();
        }
        if (decorate){
            s = "-:" + s + ":-";
        }
        return s;
    }

    public static String tellRelationToHundred(int number)
    {
        if (number <0){
            return number + " is a negative number";
        }
        else if (number > 100){
            return number + " is greater than 100";
        }
        else {
            int difference = 100-number;
            return "Add " + difference + " to " + number + " and you get 100";
        }
    }

}
