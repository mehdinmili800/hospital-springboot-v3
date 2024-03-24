package com.example.management.controller.user;

import com.example.management.dto.user.UserResponseDTO;
import com.example.management.entity.user.User;
import com.example.management.service.user.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
    @PostMapping(value = "/user/create")
    public ResponseEntity<?> addUser(@RequestBody UserResponseDTO userResponseDTO){
        User user = userService.save(userResponseDTO);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }


    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}") // Endpoint to get a user by ID
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.findById(userId); // Assuming you have a method in UserServiceImpl to find user by ID
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        User user = userService.findById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteUserById(userId);
        return ResponseEntity.ok("User with ID " + userId + " has been deleted successfully.");
    }

}
