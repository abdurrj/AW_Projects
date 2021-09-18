import java.util.Scanner;

public class CheckpointN1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String figurAntall=""; // Midlertidig verdi for å loope
        do{
            System.out.print("Hvor mange figurer ønsker du å lage? ");
            figurAntall = input.nextLine();}
        while(!figurAntall.matches("[0-9]+"));

        // Bruker Integer.parseInt() for å gjøre figurAntall som er String
        // om til figurAntallInt så vi kan behandle den som tall
        int figurAntallInt = Integer.parseInt(figurAntall.trim());

        // Lager en tom Array på størrelse med antall figurer.
        // Looper igjennom og spørr hvor stor figuren skal være for alle figurer
        // i Array
        int[] figurArray = new int[figurAntallInt];
        for (int i = 0; i<figurAntallInt; i++){

            // Samme sjekk som oppe, for å se om input er gyldig
            String figurStorrelse = "";
            do {
                System.out.printf("Skriv inn størrelsen på figur %d: ", (i + 1));
                figurStorrelse = input.nextLine();
            }while(!figurStorrelse.matches("[0-9]+"));
            figurArray[i] = Integer.parseInt(figurStorrelse.trim()); // Legger til figuren i Array
        }

        // Looper igjennom figurArray (Antall figurer)
        for (int i=0; i<figurArray.length; i++){

            // Størrelsen på figuren er tallet i figurArray
            int figurStorrelse = figurArray[i];

            // Looper antall ganger for hvor stor den er (så vi får riktig høyde)
            for (int j=0; j<figurStorrelse; j++){

                StringBuilder output = new StringBuilder(); // Lager en tom string med StringBuilder
                // Looper antall ganger for hvor stor den er (så vi får riktig bredde)
                for (int k = 0; k<figurStorrelse; k++){
                    output.append("*");
                }
                System.out.println(output); // Skriver ut en linje om gangen med *
            }
        }
    }
}
