package com.example.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private DataSource dataSource;

    public int getBooksCount(){
        int count = 0;

        try(Connection conn = dataSource.getConnection(); // Try to establish a connection
            Statement stmt = conn.createStatement();      // and on that connection, create a statement
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS C FROM BOOK") // get a resultset from that statement, by executign
        ) {
            if (rs.next()){
                count = rs.getInt("C");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return count;
    }

    public Book getBook(int bookID){
        try(Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT id, title, author, price FROM BOOK WHERE id = " + bookID+";")
        ) {
            if (rs.next()){
                return rsBook(rs);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM BOOK");
        ){
            while(rs.next()){
                books.add(rsBook(rs));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;
    }


    public List<Book> getBooksByAuthor(String author){
        List<Book> bookList = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM BOOK WHERE author = '" + author+"';");
        ) {
            while (rs.next()) {
                bookList.add(rsBook(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }

    public List<Book> getBooksByAuthorSafe(String author){
        List<Book> bookList = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM BOOK WHERE author = (?)");
        ) {
            stmnt.setString(1, author);
            ResultSet rs = stmnt.executeQuery();

            while (rs.next()) {
                bookList.add(rsBook(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }

    public List<Book> getBooksByCustomer(String customerName){
        List<Book> bookList = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(
                    "SELECT B.* " +
                        "FROM BOOK AS B " +
                        "JOIN PURCHASE AS P " +
                        "ON B.ID = P.BOOK_ID " +
                        "JOIN CUSTOMER C ON C.ID = P.CUSTOMER_ID " +
                        "WHERE C.FIRST_NAME = (?)"
            );){
            stmnt.setString(1, customerName);
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                bookList.add(rsBook(rs));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }

    public void addBook(Book book){
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(
                    "INSERT INTO BOOK(TITLE, AUTHOR, PRICE) " +
                        "VALUES(?, ?, ?)"
        );){
            stmnt.setString(1, book.getTitle());
            stmnt.setString(2, book.getAuthor());
            stmnt.setString(3, ""+book.getPrice());
            stmnt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    // Helper method to create a Book object instantiated with data from the ResultSet
    private Book rsBook(ResultSet rs) throws SQLException {
        return new Book(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("price"));
    }


    public List<Book> getBooksMeta() {
        List<Book> books = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM book")) {

// part 1
            ResultSetMetaData meta = rs.getMetaData();
            int columns = meta.getColumnCount();
            System.out.println("Columns " + columns);
            for (int i = 1; i <= columns; i++ ) {
                String name = meta.getColumnName(i);
                String type = meta.getColumnTypeName(i);
                System.out.println("Column " +name +" (" + type +")");
            }

// part 2
            System.out.println("DATA:");
            while (rs.next()){
                books.add(rsBook(rs));
                for (int i = 1; i <= columns; i++ ) {
                    String name = meta.getColumnName(i);
                    String type = meta.getColumnTypeName(i);

                    if (type.equals("BIGINT")) {
                        System.out.println(name + ": " + rs.getInt(name));
                    }
                    else if (type.equals("VARCHAR")) {
                        System.out.println(name + ": " + rs.getString(name));
                    }
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
