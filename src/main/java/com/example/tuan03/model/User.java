package com.example.tuan03.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String reEmail;
    private String password;
    private String birthday;
    private String gender;
}
