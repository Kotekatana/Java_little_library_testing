package ru.inno.ec.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AuthorForm {
    String firstName;
    String lastName;
    String patronymic;
    String dateOfBirth;
    String dateOfDeath;
}
