package com.example.controller;

import com.example.dto.ApiResponse;
import com.example.dto.author.AuthorRecord;
import com.example.dto.author.AuthorResponseRecord;
import com.example.dto.author.AuthorUpdateRecord;
import com.example.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.example.util.ApiUrls.AUTHOR_URL;

@RestController
@RequestMapping(AUTHOR_URL)
@RequiredArgsConstructor
public class AuthorController {
    private AuthorService authorService;

    // Author create
    @PostMapping()
    public ResponseEntity<ApiResponse<AuthorResponseRecord>> create(@RequestBody AuthorRecord dto) {
        return ResponseEntity.ok().body(authorService.create(dto));
    }

    // Author update
    @PutMapping()
    public ResponseEntity<ApiResponse<AuthorResponseRecord>> update(@RequestBody AuthorUpdateRecord dto) {
        return ResponseEntity.ok().body(authorService.update(dto));
    }

    // Author delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(authorService.delete(id));
    }

    // Author get id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AuthorResponseRecord>> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(authorService.getId(id));
    }

    // Author get all
    @GetMapping()
    public ResponseEntity<ApiResponse<List<AuthorResponseRecord>>> getId() {
        return ResponseEntity.ok().body(authorService.getAll());
    }
}
