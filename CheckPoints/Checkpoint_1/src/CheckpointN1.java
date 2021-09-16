import java.util.Scanner;

public class CheckpointN1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String figurAntall="";
        do{
            System.out.print("Hvor mange figurer ønsker du å lage? ");
            figurAntall = input.nextLine();}
        while(!figurAntall.matches("[0-9]+"));

        int figurAntallInt = Integer.parseInt(figurAntall.trim());
        int[] figurArray = new int[figurAntallInt];
        for (int i = 0; i<figurAntallInt; i++){
            String figurStorrelse = "";
            do {
                System.out.printf("Skriv inn størrelsen på figur %d: ", (i + 1));
                figurStorrelse = input.nextLine();
            }while(!figurStorrelse.matches("[0-9]+"));
            figurArray[i] = Integer.parseInt(figurStorrelse.trim());
        }

        for (int i=0; i<figurArray.length; i++){
            int figurStorrelse = figurArray[i];
            for (int j=0; j<figurStorrelse; j++){
                StringBuilder output = new StringBuilder();
                for (int k = 0; k<figurStorrelse; k++){
                    output.append("*");
                }
                System.out.println(output);
            }
        }
    }
}
