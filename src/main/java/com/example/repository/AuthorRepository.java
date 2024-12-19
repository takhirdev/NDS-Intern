package com.example.repository;


import com.example.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity,  Long> {
    Optional<AuthorEntity> findByFirstNameAndLastName(String firstName, String lastName);
}
