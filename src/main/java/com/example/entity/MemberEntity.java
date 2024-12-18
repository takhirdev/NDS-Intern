package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
public class MemberEntity extends AuditEntity{

    @Column(nullable = false,length = 60)
    private String name;

    @Column(length = 50, unique = true)
    private String email;

    @Column(length = 13, unique = true)
    private String phone;

}
