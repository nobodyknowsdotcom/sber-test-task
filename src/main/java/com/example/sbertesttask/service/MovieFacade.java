package com.example.sbertesttask.service;

import com.example.sbertesttask.enums.Filter;
import com.example.sbertesttask.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieFacade {
    private final MovieService movieService;

    public MovieFacade(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<Movie> handleInputQuery(Filter filter, String query){
        List<Movie> movies = new ArrayList<>();

        switch (filter) {
            case NAME -> movies = movieService.getMoviesByName(query);
            case TYPE -> movies = movieService.getMoviesByFormat(query);
            case YEAR -> movies = movieService.getMoviesByYear(query);
        }
        return movies;
    }
}
