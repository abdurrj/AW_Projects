import point.Point;

import java.util.Arrays;
import java.util.Scanner;

public class TestProgramPoint {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter point 1 coordinates (x,y): ");
        Point p1 = new Point(inputTransform());
        System.out.println(Arrays.toString(p1.getXY()));
        System.out.print("Enter point 2 coordinates (x,y): ");
        Point p2 = new Point(inputTransform());
        System.out.println(Arrays.toString(p2.getXY()));
        System.out.printf("%nDistance between point 1 and point 2: %.2f", p1.distance(p2));

    }

    private static int[] inputTransform(){
        /* Method created to transform the input to from String x,y to int[] {x,y} */
        String userInput = inputCheck();
        String[] inputArray = userInput.split(",");
        return new int[] {Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[1])};
    }

    private static String inputCheck(){
        /* Method created to check validity of the input.
        * Using nextInt() will throw an error input!= String
        * Using String.matches() with regex expression to check
        * if string is two numbers separated by comma, no spaces.*/
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        while(!userInput.matches("[0-9]+,[0-9]+")){
            System.out.print("Try again. (x,y): ");
            userInput = sc.next();
        }
        return userInput;
    }
}
