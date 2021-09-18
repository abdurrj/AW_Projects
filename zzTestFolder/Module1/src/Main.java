import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Objekttype kallenavn = nytt objekttype(parametere)
        Room room1 = new Room("LivingRoom", 4, 6);

        // Oppgaven ønsker at brukeren skal skrive en en tekst med informasjon om rommene
        // LivingRoom 3 5 & Kitchen 2 3 & Bedroom 3 4

        // Vi bruker Scanner for å la brukeren skrive informasjonen
        Scanner input = new Scanner(System.in);

        System.out.println("Enter rooms in the apartment");
        // Vi bør lagre informasjonen brukeren skriver:
        String informasjon = input.nextLine(); // nextLine siden vi ønsker mer enn bare ett ord

        // Vi ønsker å skille mellom rommene, de er separert med & tegnet
        // Dette kan vi gjøre med split() funksjonen. Den gir oss en Array tilbake

        String[] rooms = informasjon.split("&");
        // Med inputen vår, så sitter vi igjen med:
        //   index 0            index 1      index 2
        // [LivingRoom 3 5 , Kitchen 2 3 , Bedroom 3 4]

        // Vi ønsker å skrive ut detaljene på rommene på en ryddig måte
        // Den funksjonen har vi allerede i Room fila!

        // room1.printDetails(); <--.... Men vi bruker ikke room1, den var bare et eksempel.

        // Vi kan ikke bruke "LivingRoom 3 5 " for å lage et nytt Room.
        // Vi trenger en String og to separate tall. Vi må manipulere dette mer.
        // Men siden vi har tre Room vi skal gjøre det med, så skriver vi en
        // For loop, og skriver koden bare en gang, istedenfor å skrive koden flere
        // Uansett hvor mange rom vi har nå, går for loopen igjennom alle

        for (int i = 0; i<rooms.length; i++){
            // vi ønsker å skrive ut detaljer på rommene, altså bruke printDetails funksjonen
            // Men vi har foreløping ingen rom å bruke det på.
            // Vi må lage rommene, og vi har detaljene i rooms arrayen.
            String roomDetails = rooms[i]; // Siden vi looper, så tar ett rom om gangen avhengig av verdien på i
            // roomDetails ser sånn ut--> "LivingRoom 3 5 "
            // Men vi trenger: "LivingRoom" 3 og 5
            // Vi bruker en trim her, fordi Kitchen og Bedroom har faktisk et mellomrom før seg
            String[] roomDetailArray = roomDetails.trim().split(" ");
            //     index 0,        1,   2
            // --> ["LivingRoom", "3", "5 "]
            // Kan ikke bruke Integer.parseInt() på "5 ". så vi må huske å "trimme" vekk whitespace
            String roomName = roomDetailArray[0];

            // roomDetailsArray[1] er bredden som string, vi trimmer den
            // før vi bruker parseInt
            int roomWidth = Integer.parseInt(roomDetailArray[1].trim());
            int roomLength = Integer.parseInt(roomDetailArray[2].trim());

            // Nå har vi all informasjonen vi trenger, i egne variabler
            Room room = new Room(roomName, roomWidth, roomLength);
            room.printDetails();
        }

        // Siden vi looper, så går den igennom alle rommene, siden vår array har tre rom
        // Testkjører....

    }
}
