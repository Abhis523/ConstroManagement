package com.constro.insyghts.Service;
import com.constro.insyghts.Dto.UserDto;
import com.constro.insyghts.Entity.User;

import java.util.Optional;

public interface UserService {
    UserDto getUserById(Long id);
    UserDto createUser(UserDto userDTO);
    void deleteUser(Long id);
}
