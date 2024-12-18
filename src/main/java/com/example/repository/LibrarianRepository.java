package com.example.repository;

import com.example.entity.LibrarianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibrarianRepository extends JpaRepository<LibrarianEntity,Long> {
    Optional<LibrarianEntity> findByUsername(String username);
}
