import java.util.Scanner;

public class CalcEasy {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] inputArray = input.nextLine().split(" ");
        String operator = inputArray[1];
        if (!(operator.equals("+")||operator.equals("-")||operator.equals("*")||operator.equals("/"))){
            System.out.println("Invalid input");
            return;
        }
        if (operator.equals("+")){
            System.out.println(Integer.parseInt(inputArray[0]) + Integer.parseInt(inputArray[2]));
        }
        else if (operator.equals("-")){
            System.out.println(Integer.parseInt(inputArray[0]) - Integer.parseInt(inputArray[2]));
        }
        else if (operator.equals("*")){
            System.out.println(Integer.parseInt(inputArray[0]) * Integer.parseInt(inputArray[2]));
        }
        else if (operator.equals("/")){
            System.out.println(Integer.parseInt(inputArray[0]) / Integer.parseInt(inputArray[2]));
        }

    }
}
