package com.kuimov.pp.task314rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private long id;
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    public String password;
    public Set<String> roles;
}