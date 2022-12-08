package ru.inno.ec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.ec.models.Book;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book,Long> {
    List<Book> findAllByState(Book.State state);
    List<Book> findAllByAuthorId(Long id);
    List<Book> findAllByGenreId(Long id);
}
