package AmazingPackage;


public class MovieWithDirector extends Movie{
    protected String director; // Denne detaljen finnes ikke i Movie, men vi ønsker den i MovieWithDirector

    public MovieWithDirector(long productID, String title, MovieGenre movieGenre, int price, String director) {
        super(productID, title, movieGenre, price); // Start med å lage Movie objekt
        this.director = director;                   // Legg så på den siste detaljen som er director
    }


    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public void printDetails(){
    super.printDetails();       // gjør printDetails akkurat som i Movie klassen
    System.out.println(String.format("%10s","Director: ") + director); // Legg deretter til en linje med Director informasjon
    }
}
