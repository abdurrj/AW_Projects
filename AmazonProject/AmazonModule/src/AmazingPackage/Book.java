package AmazingPackage;

import java.util.ArrayList;
import java.util.List;

public class Book implements Product{
    // Alle Bøker skal ha denne informasjonen. Den settes i metoden der bøkene lages
    protected long productId;
    protected String author;
    protected String title;
    protected int price;


    // En metode for å lage bøker. Gir bøkene en tittel
    public Book(long productId, String title, String author, int price) throws Exception{
        if (productId<0) {
            throw new IncorrectProductIdException(productId);
        }
        this.productId = productId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    // Override fordi printDetails finnes allerede i "Product"
    // Men Product er en Interface, og siden Book "Implements" interface, MÅ vi ha printDetails her.
    @Override
    public void printDetails(){
        System.out.println(String.format("%8s","Title: ") + title);
        System.out.println(String.format("%8s","Author: ") + author);
        System.out.println(String.format("%8s","Price: ") + "£" +  price);
    }


    /** Ta imot en liste med bøker, og finn alle bøker av forfatter. Legg dem til i ny liste.
     * Lever den nye lista som et resultat av denne metoden
     * @param author <String>   Navnet på forfatteren.
     * @param list <List>       Liste med bøker.
     * @return List<Book>       Liste med bøker funnet som er skrevet av forfatteren
     * */
    public static List<Book> filterByAuthor(String author, List<Book> list){
        List<Book> bookList = new ArrayList<>(); // Lag en ny, tom liste
        for (Book b : list){ // Loop over alle bøker fra input lista
            if (b.author.equalsIgnoreCase(author)){
                bookList.add(b);
            }
        }
        return  bookList;
    }

    /**
     * @param bookList Liste med bøker
     * @return Siste boka lagt til i den lista.*/
    public static Book lastBookAdded(List<Book> bookList){
        return bookList.get(bookList.size()-1); // Størrelse på lista - 1 --> Siste index
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

}
