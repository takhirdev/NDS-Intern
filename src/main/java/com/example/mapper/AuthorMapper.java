package com.example.mapper;


import com.example.dto.author.AuthorRequestDTO;
import com.example.dto.author.AuthorResponseDTO;
import com.example.dto.author.AuthorUpdateDTO;
import com.example.entity.AuthorEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorEntity toEntity(AuthorRequestDTO dto);
    AuthorEntity toEntity(AuthorUpdateDTO dto);
    AuthorResponseDTO toDto(AuthorEntity dto);
    List<AuthorResponseDTO> toDto(List<AuthorEntity> dto);
}
