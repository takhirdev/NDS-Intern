package com.example.dto.book;

public record BookRequestDTO(String title,
                             Long authorId,
                             Long genreId,
                             Integer count) {
}
