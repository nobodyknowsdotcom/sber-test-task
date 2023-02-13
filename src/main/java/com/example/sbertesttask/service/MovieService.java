package com.example.sbertesttask.service;

import com.example.sbertesttask.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {
    void addMovies(List<Movie> movies);
    List<Movie> getAllMovies();
    List<Movie> getMoviesByName(String name);
    List<Movie> getMoviesByYear(String year);
    List<Movie> getMoviesByFormat(String format);
    Page<Movie> getMoviesPagination(Pageable pageable);
}
