package ru.inno.ec.services;

import ru.inno.ec.models.Genre;

import java.util.List;

public interface GenresService {
    List<Genre> getAllGenres();
    void addGenre(Genre genre);
}
