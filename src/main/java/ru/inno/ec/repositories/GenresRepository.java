package ru.inno.ec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.ec.models.Genre;

public interface GenresRepository extends JpaRepository<Genre,Long> {
}
