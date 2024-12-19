package com.example.service;

import com.example.dto.ApiResponse;
import com.example.dto.genre.GenreRecord;
import com.example.dto.genre.GenreResponseRecord;
import com.example.dto.genre.GenreUpdateRecord;
import com.example.entity.GenreEntity;
import com.example.exception.ApiException;
import com.example.mapper.GenreMapper;
import com.example.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GenreService  {
    private GenreRepository genreRepository;
    private GenreMapper genreMapper;


    // Genre create
    public ApiResponse<GenreResponseRecord> create(GenreRecord dto) {
        Optional<GenreEntity> optionalGenre = genreRepository.findByTitle(dto.title());
        if (optionalGenre.isPresent()) {
            return new ApiResponse<>("Genre already exists " + dto.title(), 400, true);
        }
        GenreEntity genreEntity = genreRepository.save(genreMapper.toEntity(dto));
        return new ApiResponse<>(201, false, genreMapper.toDto(genreEntity));
    }


    // Genre update
    public ApiResponse<GenreResponseRecord> update(GenreUpdateRecord dto) {
        getGenreId(dto.id());
        GenreEntity genreEntity = genreRepository.save(genreMapper.toEntity(dto));
        return new ApiResponse<>(200, false, genreMapper.toDto(genreEntity));
    }


    // Genre delete
    public ApiResponse<String> delete(Long id) {
        GenreEntity genreEntity = getGenreId(id);
        genreRepository.delete(genreEntity);
        return new ApiResponse<>(200, false,"Genre deleted " + genreEntity.getTitle());
    }


    // Genre get id
    public ApiResponse<GenreResponseRecord> getId(Long id) {
        return new ApiResponse<>(200, false, genreMapper.toDto(getGenreId(id)));
    }


    // Genre get all
    public ApiResponse<List<GenreResponseRecord>> getAll() {
        List<GenreEntity> entityList = genreRepository.findAll();
        return new ApiResponse<>(200, false, genreMapper.toDto(entityList));
    }


    public GenreEntity getGenreId(Long id) {
        Optional<GenreEntity> optionalGenre = genreRepository.findById(id);
        if (optionalGenre.isPresent()) {
            return optionalGenre.get();
        }
        throw new ApiException("Genre not found for id " + id);
    }

}
