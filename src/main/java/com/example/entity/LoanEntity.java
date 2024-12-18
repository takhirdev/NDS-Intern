package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan")
public class LoanEntity extends AuditEntity{

    @Column(name = "member_id")
    private Long memberId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",insertable = false, updatable = false)
    private MemberEntity member;

    @Column(name = "book_id")
    private Long bookId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id",insertable = false, updatable = false)
    private BookEntity book;

    @Column(name = "issue_date",nullable = false)
    private LocalDate issueDate;

    @Column(name = "due_date",nullable = false)
    private LocalDate dueDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

}
