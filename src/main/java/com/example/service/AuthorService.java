package com.example.service;

import com.example.dto.ApiResponse;
import com.example.dto.author.AuthorRequestDTO;
import com.example.dto.author.AuthorResponseDTO;
import com.example.dto.author.AuthorUpdateDTO;
import com.example.entity.AuthorEntity;
import com.example.exception.ApiException;
import com.example.mapper.AuthorMapper;
import com.example.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AuthorService {
    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    // Author create
    public ApiResponse<AuthorResponseDTO> create(AuthorRequestDTO dto) {
        Optional<AuthorEntity> optionalAuthor = authorRepository.findByFirstNameAndLastName(dto.firstName(), dto.lastName());
        if (optionalAuthor.isPresent()) {
            return new ApiResponse<>("Author already exists " + dto.firstName() + " " + dto.lastName(), 404, true);
        }
        AuthorEntity genreEntity = authorRepository.save(authorMapper.toEntity(dto));
        return new ApiResponse<>(201, false, authorMapper.toDto(genreEntity));
    }


    // Author update
    public ApiResponse<AuthorResponseDTO> update(AuthorUpdateDTO dto) {
        getAuthorId(dto.id());
        AuthorEntity genreEntity = authorRepository.save(authorMapper.toEntity(dto));
        return new ApiResponse<>(200, false, authorMapper.toDto(genreEntity));
    }


    // Author delete
    public ApiResponse<String> delete(Long id) {
        AuthorEntity genreEntity = getAuthorId(id);
        authorRepository.delete(genreEntity);
        return new ApiResponse<>(200, false, "Author deleted " + id);
    }


    // Author get id
    public ApiResponse<AuthorResponseDTO> getId(Long id) {
        return new ApiResponse<>(200, false, authorMapper.toDto(getAuthorId(id)));
    }


    // Author get all
    public ApiResponse<List<AuthorResponseDTO>> getAll() {
        List<AuthorEntity> entityList = authorRepository.findAll();
        return new ApiResponse<>(200, false, authorMapper.toDto(entityList));
    }


    public AuthorEntity getAuthorId(Long id) {
        Optional<AuthorEntity> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        }
        throw new ApiException("Author not found for id " + id);
    }
}
