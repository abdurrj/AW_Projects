public class Car {
    private String brand;
    private int miles;
    private final int year;

    public Car(String brand, int miles, int year) {
        this.brand = brand;
        this.miles = miles;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }


}
