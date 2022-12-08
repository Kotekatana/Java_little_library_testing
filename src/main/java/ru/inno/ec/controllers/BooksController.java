package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.inno.ec.dto.BookForm;
import ru.inno.ec.security.details.CustomUserDetails;
import ru.inno.ec.services.AuthorsService;
import ru.inno.ec.services.BooksService;
import ru.inno.ec.services.GenresService;

@Controller
@RequiredArgsConstructor
public class BooksController {
    private final BooksService booksService;
    private final AuthorsService authorsService;

    private final GenresService genresService;

    @GetMapping("/books")
    public String getBooksPage(@RequestParam(value = "genre",required = false) Long genreId,@AuthenticationPrincipal CustomUserDetails customUserDetails,Model model){
       if(genreId==null){
           model.addAttribute("books",booksService.getAllBooks());
       }else{
           model.addAttribute("books",booksService.getAllBooksByGenre(genreId));
       }
        model.addAttribute("authors",authorsService.getAllAuthors());
        model.addAttribute("genres",genresService.getAllGenres());
        model.addAttribute("role", customUserDetails.getUser().getRole());
        return "books/books_page";
    }
    @PostMapping("/books")
    public String addBook(BookForm book){
        booksService.addBook(book);
        return "redirect:/books";
    }
    @GetMapping("/books/{bookId}")
    public String getBookPage(@PathVariable Long bookId,@AuthenticationPrincipal CustomUserDetails customUserDetails,Model model){
        model.addAttribute("book",booksService.getBook(bookId));
        model.addAttribute("authors",authorsService.getAllAuthors());
        model.addAttribute("genres",genresService.getAllGenres());
        model.addAttribute("role", customUserDetails.getUser().getRole());
        return"books/book_page";
    }
    @PostMapping ("/books/{bookId}/update")
    public String updateBook(@PathVariable Long bookId,BookForm bookForm){

        return "redirect:/books";
    }
    @GetMapping("/books/{bookId}/delete")
    public String deleteBook(@PathVariable Long bookId){
        booksService.deleteBook(bookId);
        return "redirect:/books";
    }
}
