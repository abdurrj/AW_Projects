import java.util.Scanner;

public class CheckpointN2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Ønsker å sjekke gyldighet av figurAntall input i en do-while loop. Declarerer den derfor først.
        String figurAntall;
        System.out.println("Programmet kan avsluttes når du ønsker, ved å skrive avbryt");

        do{
            System.out.print("Antall figurer: ");
            figurAntall = input.nextLine();
            if (figurAntall.equals("avbryt")){
                System.out.println("Avslutter program....");
                return;
            }
        }
        // Bruker regex for å sjekke gyldigheten av brukers input. Hvis det ikke er gyldig tall, vil Systemet spørre på nytt
        // 0 figurer er lov, men det er ikke lov å skrive negativt antall figurer
        while(!figurAntall.matches("[0-9]+"));


        // Lager ny int figurAntallInt som har verdien av String tallet figurAntall.
        // Lager deretter en ny Array på størrelse med Antall ønskede figurer
        int figurAntallInt = Integer.parseInt(figurAntall);
        int[] figurArray = new int[figurAntallInt];

        if (figurAntallInt==0){
            System.out.println("Du ønsker ikke tegne figurer.\nAvslutter programmet...");
            return;
        }

        // Loop for å spørre om figurstørrelse
        for (int i = 0; i<figurAntallInt; i++){
            String figurStorrelse;
            do {
                System.out.printf("Skriv inn størrelsen på figur %d: ", (i + 1));
                figurStorrelse = input.nextLine();
                if (figurStorrelse.equals("avbryt")){
                    System.out.println("Avslutter program....");
                    return;
                }
                // Sjekker guldighet av input, lov å skrive negativ størrelse på figur
            }while(!figurStorrelse.matches("-?[0-9]+"));
            figurArray[i] = Integer.parseInt(figurStorrelse);
        }

        for (int i=0; i<figurAntallInt; i++){
            int figurStorrelse = figurArray[i];
            StringBuilder output = new StringBuilder();
            if (figurStorrelse>0) {
                for (int j = 0; j < figurStorrelse; j++) {
                    output.append("*");
                    System.out.println(output);
                }
            }
            // Hvis størrelsen på figur<0, Bruker en loop for å gjøre output til maks lengde
            // Deretter ny loop for å fjerne siste symbol.
            else if(figurStorrelse<0){
                for (int j=figurStorrelse;j<0;j++){
                    output.append("*");
                }
                for (int j = output.length(); j>0; j--){
                    System.out.println(output);
                    output.append("\b");
                }
            }
        }
    }
}
