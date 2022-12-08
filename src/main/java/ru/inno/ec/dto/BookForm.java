package ru.inno.ec.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BookForm {
    private String title;
    private String description;
    private String author;
    private String genre;
}
