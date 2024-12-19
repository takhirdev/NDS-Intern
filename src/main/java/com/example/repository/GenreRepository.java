package com.example.repository;

import com.example.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GenreRepository extends JpaRepository<GenreEntity,Long> {
    Optional<GenreEntity> findByTitle(String title);

}
