package com.example.sbertesttask.service;

import com.example.sbertesttask.enums.Format;
import com.example.sbertesttask.model.Movie;
import com.example.sbertesttask.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Реализует интерфейс MovieService и использует MovieRepository для сохранения и извлечения фильмов.
 */
@Slf4j
@Service
public class MovieServiceImpl implements MovieService{
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void addMovies(List<Movie> movies) {
        log.info(String.format("Saved %s movies, first movie: %s", movies.size(), movies.get(0).toString()));
        movieRepository.saveAll(movies);
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        log.info(String.format("Returned all movies, movies count: %s", movies.size()));
        return movies;
    }

    @Override
    public List<Movie> getMoviesByName(String name){
        List<Movie> movies = movieRepository.findAllByName(name);
        log.info(String.format("Found %s movies with name '%s'", movies.size(), name));
        return movies;
    }
    @Override
    public List<Movie> getMoviesByYear(String year){
        List<Movie> movies =  movieRepository.findAllByYear(year);
        log.info(String.format("Found %s movies with '%s' production year", movies.size(), year));
        return movies;
    }
    @Override
    public List<Movie> getMoviesByFormat(String rawFormat) {
        Format format = Format.valueOf(rawFormat.toUpperCase());

        List<Movie> movies = movieRepository.findAllByFormat(format);
        log.info(String.format("Found %s movies by '%s' format", movies.size(), format));
        return movies;
    }

    @Override
    public Page<Movie> getMoviesPagination(Pageable pageable) {
        log.info(String.format("Processing pagination request %s", pageable.toString()));
        return movieRepository.findAll(pageable);
    }
}
