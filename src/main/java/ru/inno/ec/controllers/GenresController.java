package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.inno.ec.models.Genre;
import ru.inno.ec.security.details.CustomUserDetails;
import ru.inno.ec.services.GenresService;

@Controller
@RequiredArgsConstructor
public class GenresController {
    private final GenresService genresService;

    @GetMapping("/genres")
    public String getShitsPage(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model){
        model.addAttribute("role", customUserDetails.getUser().getRole());
        model.addAttribute("genres",genresService.getAllGenres());
        return "genres/genres_page";
    }
    @PostMapping("/genres")
    public String addGenre(Genre genre){
        genresService.addGenre(genre);
        return "redirect:/genres";
    }
}
