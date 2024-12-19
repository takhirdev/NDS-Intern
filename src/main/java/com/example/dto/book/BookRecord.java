package com.example.dto.book;

public record BookRecord(String title,
                         Long authorId,
                         Long genreId,
                         Integer count) {
}
