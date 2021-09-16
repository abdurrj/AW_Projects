package AmazingPackage;

import java.util.ArrayList;
import java.util.List;

public class Book implements Product{
    protected long productId;
    protected String author;
    protected String title;
    protected int price;

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

    @Override
    public void printDetails(){
        System.out.println(String.format("%8s","Title: ") + title);
        System.out.println(String.format("%8s","Author: ") + author);
        System.out.println(String.format("%8s","Price: ") + "£" +  price);
    }

    public static List<Book> filterByAuthor(String name, List<Book> list){
        List<Book> bookList = new ArrayList<>();
        for (Book b : list){
            if (b.author.equalsIgnoreCase(name)){
                bookList.add(b);
            }
        }
        return  bookList;
    }

    public static Book lastBookAdded(List<Book> bookList){
        return bookList.get(bookList.size()-1);
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
