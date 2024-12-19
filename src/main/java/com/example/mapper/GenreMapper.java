package com.example.mapper;

import com.example.dto.genre.GenreRequestDTO;
import com.example.dto.genre.GenreResponseDTO;
import com.example.dto.genre.GenreUpdateDTO;
import com.example.entity.GenreEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreEntity toEntity(GenreRequestDTO dto);

    GenreEntity toEntity(GenreUpdateDTO dto);

    GenreResponseDTO toDto(GenreEntity dto);

    List<GenreResponseDTO> toDto(List<GenreEntity> dto);
}
