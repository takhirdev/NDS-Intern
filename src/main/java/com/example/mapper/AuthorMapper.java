package com.example.mapper;


import com.example.dto.author.AuthorRecord;
import com.example.dto.author.AuthorResponseRecord;
import com.example.dto.author.AuthorUpdateRecord;
import com.example.entity.AuthorEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorEntity toEntity(AuthorRecord dto);
    AuthorEntity toEntity(AuthorUpdateRecord dto);
    AuthorResponseRecord toDto(AuthorEntity dto);
    List<AuthorResponseRecord> toDto(List<AuthorEntity> dto);
}
