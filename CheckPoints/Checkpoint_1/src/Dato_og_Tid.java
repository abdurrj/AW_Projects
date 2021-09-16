import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.Date;

public class Dato_og_Tid {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String hundredYearsAgo = LocalDate.now().minusYears(100).format(DateTimeFormatter.ofPattern("YYYY"));
        System.out.printf("Skriv inn årstallet du ble født. Er du født før %s sørg for å skrive firesifret årstall: \n", hundredYearsAgo);
        String userInput = sc.next();
        int userInputInt = Integer.parseInt(userInput);

        if (userInput.length()<3){
            String currentYear = LocalDate.now().format(DateTimeFormatter.ofPattern("YY"));
            int userAge = Integer.parseInt(currentYear) - userInputInt;

            if (userAge<0){
                userAge +=100;
            }
            System.out.printf("Du er %d år gammel", userAge);
        }
        else{
            String currentYear = LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY"));
            int userAge = Integer.parseInt(currentYear) - userInputInt;
            if (Integer.parseInt(currentYear)<userInputInt){
                System.out.println("Hvor har du parkert tidsmaskinen din?!");
                return;
            }
            System.out.printf("Du er %d år gammel", userAge);
        }

        String currentMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM"));
        System.out.println(currentMonth);
        int currentDate = LocalDate.now().getDayOfMonth();
        System.out.println(currentDate);

        LocalDateTime futureDate = LocalDateTime.now().plusMonths(6).plusDays(2).plus(7, ChronoUnit.HOURS);
        System.out.println(futureDate.format(DateTimeFormatter.ofPattern("EE\b, MMM\b dd YYYY")));
        System.out.println(futureDate.format(DateTimeFormatter.ofPattern("MM/dd/YYYY")));
        System.out.println(futureDate.format(DateTimeFormatter.ISO_DATE));
        System.out.println(futureDate.format(DateTimeFormatter.ofPattern("MMMM YYYY")));




    }
}
