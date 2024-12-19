package com.example.controller;

import com.example.dto.ApiResponse;
import com.example.dto.author.AuthorRequestDTO;
import com.example.dto.author.AuthorResponseDTO;
import com.example.dto.author.AuthorUpdateDTO;
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
    public ResponseEntity<ApiResponse<AuthorResponseDTO>> create(@RequestBody AuthorRequestDTO dto) {
        return ResponseEntity.ok().body(authorService.create(dto));
    }

    // Author update
    @PutMapping()
    public ResponseEntity<ApiResponse<AuthorResponseDTO>> update(@RequestBody AuthorUpdateDTO dto) {
        return ResponseEntity.ok().body(authorService.update(dto));
    }

    // Author delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(authorService.delete(id));
    }

    // Author get id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AuthorResponseDTO>> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(authorService.getId(id));
    }

    // Author get all
    @GetMapping()
    public ResponseEntity<ApiResponse<List<AuthorResponseDTO>>> getId() {
        return ResponseEntity.ok().body(authorService.getAll());
    }
}
