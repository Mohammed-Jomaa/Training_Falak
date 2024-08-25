package com.FalakSolution.Trainig.model.entity;

import com.FalakSolution.Trainig.model.entity.authorEntity.Author;
import com.FalakSolution.Trainig.model.entity.bookEntity.Book;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "books_authors")
@Data

public class BookAuthorsEntity {

    @Transient
    private String authorName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ba_id")
    private Long ba_id;

    private Long book_id;

    private Long author_id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author authorEntity;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book bookEntity;

    public String getAuthorName() {
        return this.authorEntity.getFullName();
    }

}
