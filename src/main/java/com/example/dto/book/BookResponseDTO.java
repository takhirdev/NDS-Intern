package com.example.dto.book;

public record BookResponseDTO(Long id,
                              String title,
                              Long authorId,
                              Long genreId,
                              Integer count) {
}

