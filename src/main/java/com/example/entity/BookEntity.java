package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class BookEntity extends AuditEntity {

    @Column(nullable = false)
    private String title;

    @Column(name = "author_id")
    private Long authorId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id",insertable = false, updatable = false)
    private AuthorEntity author;

    @Column(name = "genre_id")
    private Long genreId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id",insertable = false, updatable = false)
    private GenreEntity genre;

    @Column(name = "count", nullable = false)
    private Integer count;

}
