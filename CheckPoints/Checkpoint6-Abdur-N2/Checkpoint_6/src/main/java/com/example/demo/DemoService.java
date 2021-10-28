package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {

    @Autowired
    DataSource dataSource;
    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getDataWithJDBC(int price) {

        // todo use JDBC to return a list of movies with a price over 42 and ordered by price descending
        List<Movie> movies = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM MOVIE WHERE PRICE > (?) ORDER BY PRICE DESC");
        ){
            stmt.setString(1, ""+price);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                movies.add(rsMovie(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return movies;
    }

    public List<Movie> getDataWithJPA(int price) {

        // todo use JPA to return a list of movies with a price over 42 and ordered by price descending
//        List<Movie> movies = new ArrayList<>();
        return (List<Movie>)movieRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    private Movie rsMovie(ResultSet rs) throws SQLException {
        return new Movie(rs.getLong("ID"),
                rs.getString("MOVIE_TITLE"),
                rs.getString("DIRECTOR"),
                rs.getInt("PRICE"));
    }
}
