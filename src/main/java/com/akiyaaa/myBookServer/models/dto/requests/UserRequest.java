package com.akiyaaa.myBookServer.models.dto.requests;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
