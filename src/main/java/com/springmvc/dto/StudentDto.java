package com.springmvc.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;
    @NotEmpty(message = "field can not be empty")
    private String firstname;
    @NotEmpty(message = "field can not be empty")
    private String lastname;
    @NotEmpty(message = "field can not be empty")
    @Email
    private String email;

}
