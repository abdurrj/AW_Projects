package AmazingPackage;

public class MovieWithDirector extends Movie{
    protected String director;

    public MovieWithDirector(long productID, String title, MovieGenre movieGenre, int price, String director) {
        super(productID, title, movieGenre, price);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void printDetails(){
        super.printDetails();
        System.out.println(String.format("%10s","Director: ") + director);
    }
}
