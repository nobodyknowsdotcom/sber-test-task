package com.example.sbertesttask.model;

import com.example.sbertesttask.enums.Format;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "movie")
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Data
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotEmpty(message = "Name may not be empty")
    String name;
    @NotEmpty(message = "Description may not be empty")
    String description;
    @NotNull(message = "Format may not be empty")
    Format format;
    @NotEmpty(message = "Genre may not be empty")
    String genre;
    @NotNull(message = "Date may not be empty")
    Date date;

    public Movie(String name, String description, Format format, String genre, Date date) {
        this.name = name;
        this.description = description;
        this.format = format;
        this.genre = genre;
        this.date = date;
    }
}
