package com.example.controller;


import com.example.dto.ApiResponse;
import com.example.dto.book.BookRecord;
import com.example.dto.book.BookResponseRecord;
import com.example.dto.book.BookUpdateRecord;
import com.example.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.example.util.ApiUrls.BOOK_URL;

@RestController
@RequestMapping(BOOK_URL)
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    // Book create
    @PostMapping()
    public ResponseEntity<ApiResponse<BookResponseRecord>> create(@RequestBody BookRecord dto) {
        return ResponseEntity.ok().body(bookService.create(dto));
    }

    // Book update
    @PutMapping()
    public ResponseEntity<ApiResponse<BookResponseRecord>> update(@RequestBody BookUpdateRecord dto) {
        return ResponseEntity.ok().body(bookService.update(dto));
    }

    // Book delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(bookService.delete(id));
    }

    // Book get id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponseRecord>> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(bookService.getId(id));
    }

    // Book get all
    @GetMapping()
    public ResponseEntity<ApiResponse<List<BookResponseRecord>>> getId() {
        return ResponseEntity.ok().body(bookService.getAll());
    }

}