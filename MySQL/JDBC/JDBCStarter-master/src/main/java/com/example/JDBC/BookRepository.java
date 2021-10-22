package com.example.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<Book> getBooksByAuthor2(String author){
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



    // Helper method to create a Book object instantiated with data from the ResultSet
    private Book rsBook(ResultSet rs) throws SQLException {
        return new Book(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("price"));
    }


}
