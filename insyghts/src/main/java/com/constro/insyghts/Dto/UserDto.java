package com.constro.insyghts.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private Set<String> roles;
}
