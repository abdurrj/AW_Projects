package com.example.avanserteforms;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieRepository {
    private List<Movie> movieList = new ArrayList<>();

    public MovieRepository(){
        Faker faker = new Faker();
        for (int i = 0; i<5; i++){
            Name director = faker.name();
            movieList.add(
                    new Movie(
                            director.title(), director.fullName()
                    )
            );
        }
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
