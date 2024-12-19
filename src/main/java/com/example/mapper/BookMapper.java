package com.example.mapper;

import com.example.dto.book.BookRequestDTO;
import com.example.dto.book.BookResponseDTO;
import com.example.dto.book.BookUpdateDTO;
import com.example.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookEntity toEntity(BookRequestDTO dto);

    BookEntity toEntity(BookUpdateDTO dto);

    BookResponseDTO toDto(BookEntity dto);

    List<BookResponseDTO> toDto(List<BookEntity> dto);
}
