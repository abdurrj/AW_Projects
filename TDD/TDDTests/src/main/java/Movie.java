public class Movie {
    private int price;
    private String name;
    private String director;

    public Movie(String name, int price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
    }

    public Movie(String name, int price) {
        this.name = name;
        this.price = price;
        this.director = "Unknown";
    }

    public String getDetails() {
        if ("Unknown".equals(director)){
            director = "Unknown director";
        }
        else{
            director = "Director: " + director.toUpperCase();
        }
        return (
                "Title: " + name +
                "\nPrice: " + price +
                "\n" + director +
                "\n"
                );
    }

    public String getPriceWithVat(){
        return "Price: " + (int)(price*1.25) + " (25% vat incl.)";
    }
}
