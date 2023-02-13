package com.example.sbertesttask.repository;

import com.example.sbertesttask.enums.Format;
import com.example.sbertesttask.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByName(String name);
    @Query(value = "SELECT * FROM movie WHERE date Like %:date%", nativeQuery = true)
    List<Movie> findAllByYear(@Param("date") String year);

    List<Movie> findAllByFormat(Format format);
}
