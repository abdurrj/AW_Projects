import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hvor mange byer skal registreres: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfCities = Integer.parseInt(scanner.nextLine());

        String[] cityNames = new String[numberOfCities];
        int[] cityInhabitants = new int[numberOfCities];

        for (int i = 0; i < numberOfCities; i++) {
            System.out.println("Navn på by nr " + (i+1) + ": ");
            cityNames[i] = scanner.nextLine();
            System.out.println("Antall innbyggere: ");
            cityInhabitants[i] = Integer.parseInt(scanner.nextLine());
        }
        displayCities(numberOfCities, cityNames, cityInhabitants);
    }


    private static void displayCities(int numberOfCities, String[] cityNames, int[] cityInhabitants) {
        
        for (int i = 0; i < numberOfCities; i++) {
            char[] displayName = new char[10];
            char[] cityNameCharArray = cityNames[i].toCharArray();
            Arrays.fill(displayName, '.');
            for (int j = 0; j<cityNameCharArray.length; j++){
                if (j>6){
                    break;
                }
                displayName[j] = cityNameCharArray[j];
            }
            String nameOutput = new String(displayName);

            System.out.print((i + 1) + ": " + nameOutput + " ");
            int size = cityInhabitants[i] / 50000;
            for (int j = 0; j < size; j++) {
                System.out.print(">");
            }
            System.out.println(cityInhabitants[i]);
        }
    }
}