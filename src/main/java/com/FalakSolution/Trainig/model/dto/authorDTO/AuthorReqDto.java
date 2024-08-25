package com.FalakSolution.Trainig.model.dto.authorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorReqDto {
    @NotNull(message = "please enter Full Name")
    private String fullName;
    @NotNull(message = "please enter title")
    private String title;
    @NotNull(message = "please enter dob")
    private Date dob;
    @NotNull(message = "please enter bio")
    private String bio;
    @NotNull(message = "please enter user name")
    private String username;
    @NotNull(message = "please enter the password")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "Password must be 8-20 characters long, containing at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    private String password;
}
