package com.example.dto.book;

public record BookUpdateRecord(Long id,
                               String title,
                               Long authorId,
                               Long genreId,
                               Integer count) {
}
