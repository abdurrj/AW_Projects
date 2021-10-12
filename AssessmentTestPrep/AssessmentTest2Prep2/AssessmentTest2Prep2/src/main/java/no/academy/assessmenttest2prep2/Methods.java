package no.academy.assessmenttest2prep2;

import java.util.*;
import java.util.stream.Collectors;

public class Methods {

    /*
        Reverse the String
     */
    public static String reverseString(String reverseThisString) {
        List<String> stringList = new ArrayList<>(List.of(reverseThisString.split("")));
        Collections.reverse(stringList);
        return String.join("",stringList);

    }

    /*
        Reverse list the list
     */
    public static List<String> reverseList(List<String> reverseThisString) {
        Collections.reverse(reverseThisString);
        return reverseThisString;
    }

    /*
        Volume of a rectangular pyramid
     */
    public static double volumeOfAPyramid(int length, int width, int height) {
        return ((length * width) * height) / 3;
    }

    /*
        Volume of a Sphere
     */
    public static double volumeOfASphere(int radius) {
        return 4*Math.PI*Math.pow(radius, 3)/3;
    }

    /*
        Use Stream and return the values in uppercase.
        Hint: map, collect.
     */
    public static List<String> yellNames(List<String> stringList) {
         return stringList.stream().map(String::toUpperCase)
                 .collect(Collectors.toList());
    }

    /*
        Get the total number of letters of names longer than five(5).
        Hint: filter, mapToInt, sum.
     */
    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        List<String> listOfNames = Arrays.asList(names);
        return listOfNames.stream()
                .filter(n-> n.length()>5)
                .mapToInt(String::length)
                .sum();
//        return 0;
    }

    /*
        Check if number is prime number or not.
     */
    public static boolean isPrimeNumber(int numberToCheck) {
        if (numberToCheck == 1 || numberToCheck == 2 || numberToCheck == 3){
            return true;
        }
        for (int i = 2; i<numberToCheck/2; i++){
            if(numberToCheck%i==0){
                return false;
            }
        }
        return true;
    }

    /*
        Very hard task
        We want to make a row of bricks that is goal inches long.
        We have a number of small bricks (1 inch each) and big bricks (5 inches each).
        Return true if it is possible to make the goal by choosing from the given bricks.
     */
    public static boolean calculateIfWeCanSucceedAtBrickLaying(int small, int big, int goal) {
        // if all small bricks + all big bricks adds up to goal,
        // We don't need to test more, result is true.
        if (small + 5*big == goal){
            return true;
        }
        // if all small bricks + all big bricks are shorter than goal
        // result is false since we can never reach our goal.
        else if(small + 5*big<goal){
            return false;
        }

        // Now we know we have enough bricks to fill the distance
        // goal / 5 --> how many big bricks can we fit in here
        // goal % 5 --> how many bricks are we short by
        // before we go over the distance
        // as long as goal % 5 <= number of small bricks, it will return true
        return (goal % 5 <= small);

// The easy way
/*        if(small + big*5 ==goal) {
            return true;
        }
        else if (small + big*5>goal){
            for (int b = 0; b <= big; b++) {
                for (int s = 0; s <= small; s++) {
                    if (5 * b + s == goal) {
                        return true;
                    }
                }
            }
        }
        return false;*/

    }


    public static int getSecondLargestNumberInArray(int[] arr1) {
        Set<Integer> list = new HashSet<>();
        for (int j : arr1) {
            list.add(j);
        }

        List<Integer> reversed =  list.stream().sorted((o1, o2) -> o2 - o1)
                .collect(Collectors.toList());
        return reversed.get(1);

//        return 0;
    }

    public static int getNumberOccurringMultipleTimes(int[] array1) {
        List<Integer> integerList = new ArrayList<>();
        for (int i : array1){
            integerList.add(i);
        }
/*        for(int i = 0; i<array1.length-1; i++){
            for (int j = 1; j<array1.length; j++){
                if (array1[i]==array1[j]){
                    return array1[i];
                }
            }
        }
        return 0;*/
        List<Integer> multiOccuranceList = integerList.stream()
                .filter(o1->Collections.frequency(integerList,o1)>1)
                .collect(Collectors.toList());
        return multiOccuranceList.get(0);
    }

    public static List<Integer> doubleAllValuesWithStream(List<Integer> array1) {
        return array1.stream()
                .map(o1 -> o1*2)
                .collect(Collectors.toList());
/*
        List<Integer> numsDoubled = new ArrayList<>();
        for (Integer i : array1){
            numsDoubled.add(i*2);
        }
        return numsDoubled;
*/
    }

    public static List<String> filterAndUppercaseAndSort(List<String> aList) {
        return aList.stream()
                .filter(o1-> o1.startsWith("c"))
                .map(String::toUpperCase)
//                .sorted(String::compareTo)
                .sorted(Comparator.comparing(p->p))
                .collect(Collectors.toList());
    }
}
