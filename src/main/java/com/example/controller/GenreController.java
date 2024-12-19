package com.example.controller;

import com.example.dto.ApiResponse;
import com.example.dto.genre.GenreRequestDTO;
import com.example.dto.genre.GenreResponseDTO;
import com.example.dto.genre.GenreUpdateDTO;
import com.example.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.util.ApiUrls.GENRE_URL;

@RestController
@RequestMapping(GENRE_URL)
@AllArgsConstructor
public class GenreController {
    private GenreService genreService;

    // Genre create
    @PostMapping()
    public ResponseEntity<ApiResponse<GenreResponseDTO>> create(@RequestBody GenreRequestDTO dto){
        return ResponseEntity.ok().body(genreService.create(dto));
    }

    // Genre update
    @PutMapping()
    public ResponseEntity<ApiResponse<GenreResponseDTO>> update(@RequestBody GenreUpdateDTO dto){
        return ResponseEntity.ok().body(genreService.update(dto));
    }

    // Genre delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id){
        return ResponseEntity.ok().body(genreService.delete(id));
    }

    // Genre get id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GenreResponseDTO>> getId(@PathVariable Long id){
        return ResponseEntity.ok().body(genreService.getId(id));
    }

    // Genre get all
    @GetMapping()
    public ResponseEntity<ApiResponse<List<GenreResponseDTO>>> getId(){
        return ResponseEntity.ok().body(genreService.getAll());
    }

}
