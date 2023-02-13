package com.example.sbertesttask.controller;

import com.example.sbertesttask.enums.Filter;
import com.example.sbertesttask.model.Movie;
import com.example.sbertesttask.service.MovieFacade;
import com.example.sbertesttask.service.MovieServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movie-api/")
public class MovieController {
    private final MovieServiceImpl movieServiceImpl;
    private final MovieFacade movieFacade;

    public MovieController(MovieServiceImpl movieServiceImpl, MovieFacade movieFacade) {
        this.movieServiceImpl = movieServiceImpl;
        this.movieFacade = movieFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Valid @RequestBody List<Movie> movies){
        movieServiceImpl.addMovies(movies);
    }

    @GetMapping
    public List<Movie> getByFilter(@RequestParam Filter filter, @RequestParam String query){
        return movieFacade.handleInputQuery(filter, query);
    }
    @GetMapping(path = "/all")
    public List<Movie> getAll(){
        return movieServiceImpl.getAllMovies();
    }
}
