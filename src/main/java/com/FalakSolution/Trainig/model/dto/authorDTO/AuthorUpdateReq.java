package com.FalakSolution.Trainig.model.dto.authorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorUpdateReq {

    private Long author_id;
    @NotNull(message = "please enter Full Name")
    private String fullName;
    @NotNull(message = "please enter title")
    private String title;
    @NotNull(message = "please enter dob")
    private Date dob;
    @NotNull(message = "please enter bio")
    private String bio;

}
