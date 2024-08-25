package com.FalakSolution.Trainig.model.dto.authorDTO;

import com.FalakSolution.Trainig.model.entity.BookAuthorsEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AuthorsBookDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer author_id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "title")
    private String title;

    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "bio")
    private String bio;

    @JsonManagedReference
    @OneToMany(mappedBy = "authorEntity")
    private List<BookAuthorsEntity> bookAuthors;

}
