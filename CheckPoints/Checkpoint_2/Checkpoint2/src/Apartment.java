public class Apartment {
    char apartmentType;
    Room room1;
    Room room2;
    Room room3;

    // Alle Apartment har en apartment type, og tre rom i seg.
    public Apartment(char apartmentType, Room room1, Room room2, Room room3) {
        this.apartmentType = apartmentType;
        this.room1 = room1;
        this.room2 = room2;
        this.room3 = room3;
    }

    public void printDetails(){
        System.out.println("Apartment type: " + apartmentType);
        room1.printDetails();
        room2.printDetails();
        room3.printDetails();
    }
}
