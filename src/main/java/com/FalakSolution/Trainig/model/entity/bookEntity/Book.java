package com.FalakSolution.Trainig.model.entity.bookEntity;

import com.FalakSolution.Trainig.model.entity.BookAuthorsEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
    @Table(name = "book")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "book_id")
        private Long book_id;

        private String title;

        private String subtitle;

        private String description;

        private String imageURL;

        private String edition;

        @Temporal(TemporalType.DATE)
        private Date publishing_date;

        private String categories;

        @JsonManagedReference
        @OneToMany(mappedBy = "bookEntity")
        private List<BookAuthorsEntity> bookAuthors;

    }

