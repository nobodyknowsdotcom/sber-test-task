package com.example.sbertesttask.model;

import com.example.sbertesttask.enums.Format;
import com.example.sbertesttask.enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "movie")
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id;
    @NotEmpty(message = "Name may not be empty")
    @Size(min=1, max=64)
    String name;
    @NotNull(message = "Description may not be empty")
    @Size(max=256)
    String description;
    @NotNull(message = "Format may not be empty")
    @Enumerated(EnumType.STRING)
    Format format;
    @NotNull(message = "Genre may not be empty")
    @Enumerated(EnumType.STRING)
    Genre genre;
    @NotNull(message = "Date may not be empty")
    Date date;

    public Movie(String name, String description, Format format, Genre genre, Date date) {
        this.name = name;
        this.description = description;
        this.format = format;
        this.genre = genre;
        this.date = date;
    }
}
