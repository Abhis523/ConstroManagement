package com.constro.insyghts.Assembller;

import com.constro.insyghts.Dto.UserDto;
import com.constro.insyghts.Entity.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
@Component
public class UserAssembler {
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        // Check for null and initialize if needed
        Set<String> roleNames = user.getRoles() != null
                ? user.getRoles().stream().map(role -> role.getName()).collect(Collectors.toSet())
                : Collections.emptySet();
        userDto.setRoles(roleNames);        return userDto;
    }

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        // Set roles accordingly
        return user;
    }
}
