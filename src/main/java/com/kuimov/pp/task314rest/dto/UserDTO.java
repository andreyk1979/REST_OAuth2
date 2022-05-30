package com.kuimov.pp.task314rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private long id;
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    public String password;
    Set<String> roles;
}