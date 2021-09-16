package AmazingPackage;

import java.util.List;
import java.util.Map;

public class Movie implements Product, Comparable<Movie>{
    protected long productId;
    private MovieGenre movieGenre;
    private String title;
    protected int price;


    public Movie(long productID, String title, MovieGenre movieGenre, int price) {
        if (productID<=0) {
            throw new IllegalArgumentException("Illegal productId! Cannot be a negative number!");
        }
        this.productId = productID;
        this.title = title;
        this.movieGenre = movieGenre;
        this.price = price;
    }

    // Start setters and getters

    public int getPrice() {
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setProductId(long id){
        this.productId = id;
    }

    public long getProductId(){
        return productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieGenre getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(MovieGenre movieGenre) {
        this.movieGenre = movieGenre;
    }

    // End setters and getters


    public void printDetails(){
        System.out.println(String.format("%10s","ID: ") + productId);
        System.out.println(String.format("%10s", "Price: ") + "£"+price);
        System.out.println(String.format("%10s","Title: ") + title);
        System.out.println(String.format("%10s", "Genre: ") + movieGenre);
    }


    // Start Search functions

    public static Movie findMovieById(long id, Map<Long, Movie> movieMap) {
        Movie m = movieMap.get(id);
        return movieMap.get(id);
    }

    public static Movie findMovieById(long id, List<Movie> movieList){
        for (Movie m : movieList) {
            if (m.productId == id){
                return m;
            }
        }
            return null;
    }

    @Override
    public int compareTo(Movie movie) {
        if (productId == movie.productId){
            return 0;
        }
        else if (productId > movie.productId){
            return 1;
        }
        else{
            return -1;
        }
    }

    // End search functions


}

