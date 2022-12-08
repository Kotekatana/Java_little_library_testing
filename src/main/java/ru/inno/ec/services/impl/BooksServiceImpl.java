package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.ec.dto.BookForm;
import ru.inno.ec.models.Book;
import ru.inno.ec.repositories.AuthorsRepository;
import ru.inno.ec.repositories.BooksRepository;
import ru.inno.ec.repositories.GenresRepository;
import ru.inno.ec.services.BooksService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BooksServiceImpl implements BooksService {
    private final BooksRepository booksRepository;
    private final GenresRepository genresRepository;
    private final AuthorsRepository authorsRepository;

    @Override
    public List<Book> getAllBooks() {
        return booksRepository.findAllByState(Book.State.FREE);
    }

    @Override
    public List<Book> getAllBooksByGenre(Long id) {
        return booksRepository.findAllByGenreId(id);
    }

    @Override
    public void addBook(BookForm book) {
        Book newBook = Book.builder()
                .title(book.getTitle())
                .description(book.getDescription())
                .author(authorsRepository.findById(Long.parseLong(book.getAuthor())).orElseThrow())
                .genre(genresRepository.findById(Long.parseLong(book.getGenre())).orElseThrow())
                .state(Book.State.FREE)
                .build();
        booksRepository.save(newBook);
    }

    public Book getBook(Long id){
        return booksRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteBook(Long id) {
        Book deletedBook = booksRepository.findById(id).orElseThrow();
        deletedBook.setState(Book.State.DELETED);
        booksRepository.save(deletedBook);
    }

    @Override
    public void updateBook(Long id, BookForm book) {
        Book bookForUpdate = booksRepository.findById(id).orElseThrow();
        bookForUpdate.setTitle(book.getTitle());
        bookForUpdate.setAuthor(authorsRepository.findById(Long.parseLong(book.getAuthor())).orElseThrow());
        bookForUpdate.setGenre(genresRepository.findById(Long.parseLong(book.getGenre())).orElseThrow());
        bookForUpdate.setDescription(book.getDescription());

        booksRepository.save(bookForUpdate);
    }
    public List<Book> getAllBooksByAuthorId(Long id){
        return booksRepository.findAllByAuthorId(id);
    }
}
