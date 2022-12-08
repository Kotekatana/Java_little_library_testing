package ru.inno.ec.models;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"author", "genre"})
@Builder
@Entity
@ToString
public class Book {
    public enum State{
        DELETED,FREE,RESERVED
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @Enumerated(value = EnumType.STRING)
    private State state;
}
