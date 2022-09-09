package com.onnorokompathshala.videosharingproject.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRegisterDTO {

    private String name;
    @NotEmpty
    @Email(message = "Email address is not valid !!")
    private String email;
    @Size(min = 3, max = 15, message = "Password must be min of 3 characters" +
            "and maximum of 15 characters")
    private String password;

}
