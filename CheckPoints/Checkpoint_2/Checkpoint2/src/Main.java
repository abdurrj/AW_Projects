import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter apartment type (A, B, C):");
        char apartmentType = (sc.next().toCharArray())[0];
        sc.nextLine();
        System.out.println("Enter rooms in the apartment: ");
        String input = sc.nextLine();

        // Split input to separate rooms
        String[] inputArray = input.split("&");
        List<Room> roomList = new ArrayList<>();

        // Input handling, creating rooms
        for (int i = 0; i< inputArray.length; i++){
            String[] roomDetails = inputArray[i].trim().split(" ");
            String roomName = roomDetails[0];
            int roomWidth = Integer.parseInt(roomDetails[1].trim());
            int roomLength = Integer.parseInt(roomDetails[2].trim());
            roomList.add(new Room(roomName, roomWidth, roomLength));
        }

        // Creating apartment, adding rooms
        Apartment apartment = new Apartment(apartmentType, roomList.get(0), roomList.get(1), roomList.get(2));

        apartment.printDetails();

    }

}