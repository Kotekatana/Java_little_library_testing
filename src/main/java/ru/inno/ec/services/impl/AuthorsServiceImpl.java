package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.ec.dto.AuthorForm;
import ru.inno.ec.models.Author;
import ru.inno.ec.repositories.AuthorsRepository;
import ru.inno.ec.services.AuthorsService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@RequiredArgsConstructor
@Service
public class AuthorsServiceImpl implements AuthorsService {
    private final AuthorsRepository authorsRepository;

    @Override
    public Author getAuthor(Long id) {
        return authorsRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteAuthor(Long id) {
        Author deletedAuthor = authorsRepository.findById(id).orElseThrow();
        deletedAuthor.setState(Author.State.DELETED);
        authorsRepository.save(deletedAuthor);
    }

    @Override
    public void addAuthor(AuthorForm author) {

        System.out.println(author.getFirstName());
        Author newAuthor = Author.builder()
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .patronymic(author.getPatronymic())
                .state(Author.State.CREATED)
                .build();
        if(!author.getDateOfBirth().equals("")){
            newAuthor.setDateOfBirth(LocalDate.parse(author.getDateOfBirth()));
        }
        if(!author.getDateOfDeath().equals("")){
            newAuthor.setDateOfDeath(LocalDate.parse(author.getDateOfDeath()));
        }
        authorsRepository.save(newAuthor);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorsRepository.findAllByStateNot(Author.State.DELETED);
    }
}
