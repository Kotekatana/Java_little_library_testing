package ru.inno.ec.services;

import ru.inno.ec.dto.AuthorForm;
import ru.inno.ec.models.Author;

import java.util.List;

public interface AuthorsService {
    List<Author> getAllAuthors();

    void addAuthor(AuthorForm author);

    Author getAuthor(Long id);

    void deleteAuthor(Long id);
}
