package com.example.management.service.user.user;

import com.example.management.dto.user.UserResponseDTO;
import com.example.management.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(UserResponseDTO userResponseDTO);

    List<User> findAll();

    User findById(Long userId); // New method declaration

    void deleteUserById(Long userId);

    User findByUsername(String username);

}
