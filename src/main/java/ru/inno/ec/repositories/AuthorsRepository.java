package ru.inno.ec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.ec.models.Author;

import java.util.List;

public interface AuthorsRepository extends JpaRepository<Author,Long> {
    List<Author> findAllByStateNot(Author.State state);
}
