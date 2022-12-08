package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.inno.ec.dto.AuthorForm;
import ru.inno.ec.security.details.CustomUserDetails;
import ru.inno.ec.services.AuthorsService;
import ru.inno.ec.services.BooksService;

@RequiredArgsConstructor
@Controller

public class AuthorsController {
    private final AuthorsService authorsService;
    private final BooksService booksService;

    @GetMapping("/authors")
    public String getAuthorsPage(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model){
        model.addAttribute("role", customUserDetails.getUser().getRole());
        model.addAttribute("authors",authorsService.getAllAuthors());
        return "authors/authors_page";
    }
    @GetMapping("/authors/{authorId}")
    public String getAuthorPage(@AuthenticationPrincipal CustomUserDetails customUserDetails,@PathVariable Long authorId, Model model){
        model.addAttribute("role", customUserDetails.getUser().getRole());
        model.addAttribute("author",authorsService.getAuthor(authorId));
        model.addAttribute("books",booksService.getAllBooksByAuthorId(authorId));

        return "authors/author_page";
    }
    @PostMapping("/authors")
    public String addAuthor(AuthorForm author){
        authorsService.addAuthor(author);
        return "redirect:/authors";
    }
    @GetMapping ("/authors/{authorId}/delete")
    public String deleteAuthor(@PathVariable Long authorId){
        authorsService.deleteAuthor(authorId);
        return "redirect:/authors";
    }
}
