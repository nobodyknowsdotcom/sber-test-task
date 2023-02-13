package com.example.sbertesttask.controller;

import com.example.sbertesttask.enums.Filter;
import com.example.sbertesttask.model.Movie;
import com.example.sbertesttask.service.MovieFacade;
import com.example.sbertesttask.service.MovieServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    /**
     * Принимает список фильмов в качестве тела запроса, проверяет их и затем сохраняет в базу данных.
     *
     * @param movies Список фильмов для сохранения
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Valid @RequestBody List<Movie> movies){
        movieServiceImpl.addMovies(movies);
    }

    /**
     * Принимает фильтр и запрос и возвращает список фильмов, соответствующих фильтру и запросу.
     *
     * @param filter фильтр, который будет использоваться для поиска фильмов.
     * @param query строка запроса, которую вводит пользователь
     * @return Список фильмов
     */
    @GetMapping
    public List<Movie> getByFilter(@RequestParam Filter filter, @RequestParam String query){
        return movieFacade.handleInputQuery(filter, query);
    }
    @GetMapping(path = "/pagination")
    public Page<Movie> getPage(@NotNull Pageable pageable){
        return movieServiceImpl.getMoviesPagination(pageable);
    }
    @GetMapping(path = "/all")
    public List<Movie> getAll(){
        return movieServiceImpl.getAllMovies();
    }
}
