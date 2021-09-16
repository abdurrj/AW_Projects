import AmazingPackage.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonProject {

    public static void main(String[] args) throws Exception{
        System.out.println();
        Book book1 = null;
        Book book2 = null;
        Book book3 = null;
        Book book4 = null;
        Book book5 = null;
        Book book6 = null;
        Book book7 = null;

        try{
            book1 = new Book(1122,"Map of Bones", "James Rollins", 30);
            book2 = new Book(2233, "The Lord Of The Rings", "J.R.R. Tolkien",50);
            book3 = new Book(3344, "The Hobbit", "J.R.R. Tolkien",50);
            book4 = new Book(4455, "HP 1", "J.K. Rowling",10);
            book5 = new Book(5566, "HP 2", "J.K. Rowling",10);
            book6 = new Book(6677, "HP 3", "J.K. Rowling",10);
            book7 = new Book(-5, "HP 4", "J.K. Rowling",10);
        }
        catch(IncorrectProductIdException e){
            e.printStackTrace();
        }

        ChildrenBook childrenBook = new ChildrenBook(8899,"Minsten", "unknown", 10, 1);
        Book childBookTest = new ChildrenBook(9900, "Pippi", "Astrid Lindgren", 10, 4);

/*        Movie movie1 = null;
        Movie movie2 = null;
        Movie movie3 = null;
        Movie movie4 = null;
        Movie movie5 = null;
        Movie movie6 = null;



        try {
            movie1 = new Movie(5, "Kung Fu Panda", MovieGenre.COMEDY, 40);
            movie2 = new Movie(2345, "LOTR1", MovieGenre.ACTION, 35);
            movie3 = new MovieWithDirector(4545, "LOTR2", MovieGenre.ACTION, 40, "Peter Jackson");
            movie4 = new Movie(134, "Matrix", MovieGenre.ACTION, 30);
            movie5 = new Movie(44, "The Lion King", MovieGenre.DRAMA, 15);
            movie6 = new Movie(-5, "Ghost Busters", MovieGenre.COMEDY, 25);
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }*/
        /*

        Movie[] mArray = new Movie[6];
        mArray[0] = movie1;
        mArray[1] = movie2;
        mArray[2] = movie3;
        mArray[3] = movie4;
        mArray[4] = movie5;
        mArray[5] = movie6;

        for (Movie m : mArray){
            if (m!=null) {
                m.printDetails();
            }
        }*/
/*

        List<Movie> movieCatchList = new ArrayList<>();
        for (int i = 0; i<movieID.length; i++){
            try{
                Movie m = new Movie(....)
                movieCatchList.add(m);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


*/



        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book7);
        bookList.add(book5);
        bookList.add(book4);
        bookList.add(book6);

      // Extends and override, standard method and casting

/*        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie3);
        movies.add(movie2);
        movies.add(movie6);
        movies.add(movie4);
        movies.add(movie5);

        Collections.sort(movies);

        List<Product> products = new ArrayList<>(movies);

        for (Product p : products){
            p.printDetails();
            System.out.println();
        }*/

// Creating product list

/*
        for (Product p : productList){
            if (p instanceof Book){
                if (p instanceof ChildrenBook){
                    ((ChildrenBook) p).printBookDetails();
                }
                else {
                    ((Book) p).printBookDetails();
                }
            }
            else if (p instanceof Movie){
                ((Movie) p).printMovieDetails();
            }
            System.out.println();
        }
*/
// With specific method names

/*
        for (Product p : productList){
            p.printDetails();
            System.out.println();
        }
*/
// Looping through product list and printing details


/*
        for (int i = 0; i<bookList.size(); i++){
            // Hvis objektet er null, gå vi til neste. Velger continue istedenfor
            // Break Array list kan kanskje se ut som {book1, book2, null, book4}
            bookList.get(i).printBookDetails();
            System.out.println();
        }
*/
// loop through book list

/*
        Map<Long, Movie> movieMap = new HashMap<>();
        movieMap.put(movie1.getProductId(), movie1);
        movieMap.put(movie2.getProductId(), movie2);
        movieMap.put(movie3.getProductId(), movie3);

        long searchID = 4545;
        Movie m = Movie.findMovieById(searchID, movieMap);
        if (m==null){
            System.out.printf("No movie found by ID: %d", searchID);
        }
        else{
            System.out.println("Movie found: ");
            m.printMovieDetails();
        }
*/
// Searching movie id through Map

/*
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        for (Movie m : movieList) {
             Hvis objektet er null, gå vi til neste. Velger continue istedenfor
             Break Array list kan kanskje se ut som {movie1, movie2, null, movie4}
            if (m == null){
                continue;

            m.printMovieDetails();
        }*/
// Looping through list, printing movie details

/*      Search movie by ID
        long searchID = 9999;
        Movie m = Movie.findMovieById(searchID,movieList);

        if (m==null){
            System.out.printf("No movie found by ID: %d", searchID);
        }
        else{
            System.out.println("Movie found: ");
            m.printMovieDetails();
        }
*/
// Searching movie id through list

/*
        System.out.println("Searching for books by J.R.R. Tolkien");
        List<Book> authorBooks = Book.filterByAuthor("J.K. Rowling", bookList);
        for (Book b : authorBooks) {
            b.printDetails();
            System.out.println();
        }
*/
// Searching for author

    }

}
