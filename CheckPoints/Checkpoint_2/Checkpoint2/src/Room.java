public class Room {

    private final String name;
    private final int width;
    private final int length;

    public Room(String name, int width, int length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }

    public void printDetails(){
        System.out.println("Room: " + name);
        System.out.println("Width and length: " + width + " x " + length + " m");
        System.out.println("Area: " + width*length + "m²");
    }

// Setters and getters, but not needed
/*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
*/

}
