package com.example.service;

import com.example.dto.ApiResponse;
import com.example.dto.book.BookRecord;
import com.example.dto.book.BookResponseRecord;
import com.example.dto.book.BookUpdateRecord;
import com.example.entity.BookEntity;
import com.example.exception.ApiException;
import com.example.mapper.BookMapper;
import com.example.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    private final AuthorService authorService;
    private final GenreService genreService;

    // Book create
    public ApiResponse<BookResponseRecord> create(BookRecord dto) {

        authorService.getAuthorId(dto.authorId());
        genreService.getGenreId(dto.genreId());

        BookEntity genreEntity = bookRepository.save(bookMapper.toEntity(dto));
        return new ApiResponse<>(201, false, bookMapper.toDto(genreEntity));
    }


    // Book update
    public ApiResponse<BookResponseRecord> update(BookUpdateRecord dto) {

        getBookId(dto.id());
        authorService.getAuthorId(dto.authorId());
        genreService.getGenreId(dto.genreId());

        BookEntity genreEntity = bookRepository.save(bookMapper.toEntity(dto));
        return new ApiResponse<>(200, false, bookMapper.toDto(genreEntity));
    }


    // Book delete
    public ApiResponse<String> delete(Long id) {
        BookEntity genreEntity = getBookId(id);
        bookRepository.delete(genreEntity);
        return new ApiResponse<>(200, false, "Book deleted " + id);
    }


    // Book get id
    public ApiResponse<BookResponseRecord> getId(Long id) {
        return new ApiResponse<>(200, false, bookMapper.toDto(getBookId(id)));
    }


    // Book get all
    public ApiResponse<List<BookResponseRecord>> getAll() {
        List<BookEntity> entityList = bookRepository.findAll();
        return new ApiResponse<>(200, false, bookMapper.toDto(entityList));
    }


    public BookEntity getBookId(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ApiException("Book not found for id " + id));
    }

}
