package com.FalakSolution.Trainig.model.dto.BookDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookUpdateReq {

    private Long book_id;
    @NotNull(message = "Title cannot be null")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String title;

    @Size(max = 100, message = "Subtitle must be less than 100 characters")
    private String subtitle;

    @NotNull(message = "Description cannot be null")
    @Size(min = 1, message = "Description cannot be empty")
    private String description;

    @NotNull(message = "Image URL cannot be null")
    @Pattern(
            regexp = "^(http|https)://.*$",
            message = "Image URL must be a valid URL"
    )
    private String imageURL;

    @NotNull(message = "Edition cannot be null")
    @Size(min = 1, max = 50, message = "Edition must be between 1 and 50 characters")
    private String edition;

    @NotNull(message = "Publishing date cannot be null")
    @PastOrPresent(message = "Publishing date must be in the past or present")
    private Date publishing_date;

    @NotNull(message = "Categories cannot be null")
    @Size(min = 1, message = "Categories cannot be empty")
    private String categories;
}
