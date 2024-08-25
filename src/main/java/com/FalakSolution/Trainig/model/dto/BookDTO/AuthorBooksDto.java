package com.FalakSolution.Trainig.model.dto.BookDTO;

import com.FalakSolution.Trainig.model.entity.BookAuthorsEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AuthorBooksDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer book_id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "description")
    private String description;

    @Column(name = "imageURL")
    private String imageURL;

    @Column(name = "edition")
    private String edition;

    @Column(name = "publishing_date")
    @Temporal(TemporalType.DATE)
    private Date publishing_date;

    @Column(name = "categories")
    private String categories;

    @JsonManagedReference
    @OneToMany(mappedBy = "bookEntity")
    private List<BookAuthorsEntity> bookAuthors;

}
