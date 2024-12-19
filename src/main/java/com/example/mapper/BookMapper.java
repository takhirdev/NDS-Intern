package com.example.mapper;

import com.example.dto.book.BookRecord;
import com.example.dto.book.BookResponseRecord;
import com.example.dto.book.BookUpdateRecord;
import com.example.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookEntity toEntity(BookRecord dto);

    BookEntity toEntity(BookUpdateRecord dto);

    BookResponseRecord toDto(BookEntity dto);

    List<BookResponseRecord> toDto(List<BookEntity> dto);
}
