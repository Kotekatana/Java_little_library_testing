package ru.inno.ec.services;

import ru.inno.ec.dto.BookForm;
import ru.inno.ec.models.Book;

import java.util.List;

public interface BooksService {
    List<Book> getAllBooks();
    List<Book> getAllBooksByGenre(Long id);
    void addBook(BookForm book);
    Book getBook(Long id);
    void deleteBook(Long id);

    void updateBook(Long id,BookForm book);
    List<Book> getAllBooksByAuthorId(Long id);
}
