package com.FalakSolution.Trainig.model.entity.authorEntity;

import com.FalakSolution.Trainig.model.entity.BookAuthorsEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long author_id;

    @Column(name = "full_name")
    private String fullName;

    private String title;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String bio;

    private String username;

    private String password;

    @JsonManagedReference
    @OneToMany(mappedBy = "authorEntity")
    private List<BookAuthorsEntity> bookAuthors;

}
