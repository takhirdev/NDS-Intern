package com.example.dto.book;

public record BookResponseRecord(Long id,
                                 String title,
                                 Long authorId,
                                 Long genreId,
                                 Integer count) {
}

