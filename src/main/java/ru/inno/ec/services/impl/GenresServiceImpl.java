package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.ec.models.Genre;
import ru.inno.ec.repositories.GenresRepository;
import ru.inno.ec.services.GenresService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GenresServiceImpl implements GenresService{
    private final GenresRepository genresRepository;
    @Override
    public List<Genre> getAllGenres() {
        return genresRepository.findAll();
    }

    @Override
    public void addGenre(Genre genre) {
        genresRepository.save(genre);
    }



}

