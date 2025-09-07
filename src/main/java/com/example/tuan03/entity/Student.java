package com.example.tuan03.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    String firstName;
    String lastName;
    String birthday;
    String email;
    String mobile;
    String gender;
    String address;
    String city;
    String pinCode;
    String state;
    String country;
    String hobby;
    String qualification;
    String courseApplyFor;
}
