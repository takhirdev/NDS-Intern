package com.example.dto.book;

public record BookUpdateDTO(Long id,
                            String title,
                            Long authorId,
                            Long genreId,
                            Integer count) {
}
