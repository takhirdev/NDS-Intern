package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author", uniqueConstraints = @UniqueConstraint(columnNames = {"firstName", "lastName"}))
public class AuthorEntity extends AuditEntity{

    @Column(nullable = false, length = 60)
    private String firstName;

    @Column(nullable = false, length = 60)
    private String lastName;

}
