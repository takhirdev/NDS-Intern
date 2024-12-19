package com.example.mapper;

import com.example.dto.genre.GenreRecord;
import com.example.dto.genre.GenreResponseRecord;
import com.example.dto.genre.GenreUpdateRecord;
import com.example.entity.GenreEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreEntity toEntity(GenreRecord dto);

    GenreEntity toEntity(GenreUpdateRecord dto);

    GenreResponseRecord toDto(GenreEntity dto);

    List<GenreResponseRecord> toDto(List<GenreEntity> dto);
}
