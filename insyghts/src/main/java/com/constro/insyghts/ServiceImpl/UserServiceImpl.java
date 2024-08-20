package com.constro.insyghts.ServiceImpl;
import com.constro.insyghts.Assembller.UserAssembler;
import com.constro.insyghts.Dto.UserDto;
import com.constro.insyghts.Entity.User;
import com.constro.insyghts.Exception.ResourceNotFoundException;
import com.constro.insyghts.Repository.UserRepository;
import com.constro.insyghts.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAssembler userAssembler;

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findByIdAndNotDeleted(id)
                .orElseThrow(() -> new RuntimeException("User not found or has been deleted"));
        return userAssembler.toDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken");
        }

        // Check if a user with the same email already exists
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already in use");
        }

        // Proceed with creating the user
        User user = userAssembler.toEntity(userDto);
        userRepository.save(user);

        return userAssembler.toDto(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setDeleted(true);
        userRepository.save(user);
    }
}
