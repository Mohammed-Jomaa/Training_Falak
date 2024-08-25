package com.FalakSolution.Trainig.model.dto.BookDTO;

import com.FalakSolution.Trainig.model.entity.BookAuthorsEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResDto {
    private Long book_id;
    private String title;
    private String subtitle;
    private String description;
    private String imageURL;
    private String edition;
    private Date publishing_date;
    private String categories;
    @JsonManagedReference
    @OneToMany(mappedBy = "bookEntity")
    private List<BookAuthorsEntity> bookAuthors;

}
