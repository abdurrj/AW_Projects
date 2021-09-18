import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        // Ny Scanner, spør brukeren om Apartment type og leser inn informasjon og gjør det til en char
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter apartment type (A, B, C):");
        char apartmentType = (sc.next().toCharArray())[0];

        // sc.next alene ender opp med å sende linjeskift til neste scanner.
        // Vi setter derfor denne her, ellers vil neste scanner som skal lese informasjon
        // kun lese linjeskift og programmet kræsjer
        sc.nextLine();
        System.out.println("Enter rooms in the apartment: ");
        String input = sc.nextLine(); // Skriver: LivingRoom 4 5 & Kitchen 3 5 & bedroom 3 4

        // Split input to separate rooms              //    index 0        index 1          index 2
        String[] inputArray = input.split("&"); // [LivingRoom 4 5 , Kitchen 3 5 , Bedroom 3 4]
        List<Room> roomList = new ArrayList<>();

        // Input handling, creating rooms
        for (int i = 0; i< inputArray.length; i++){
            String[] roomDetails = inputArray[i].trim().split(" "); // [LivingRoom, 4, 5] osv for de andre
            String roomName = roomDetails[0];
            int roomWidth = Integer.parseInt(roomDetails[1].trim());
            int roomLength = Integer.parseInt(roomDetails[2].trim());
            roomList.add(new Room(roomName, roomWidth, roomLength)); // Lager nytt rom med detaljene og lagrer i roomList
        }

        // Lager ny apartment med apartmentType og roomList(som vi fylte med 3 room)
        Apartment apartment = new Apartment(apartmentType, roomList.get(0), roomList.get(1), roomList.get(2));

        apartment.printDetails();

    }

}