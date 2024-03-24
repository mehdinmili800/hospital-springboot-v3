package com.example.management.service.user.user.impl;

import com.example.management.config.JwtService;
import com.example.management.config.token.TokenEntity;
import com.example.management.config.token.TokenRepository;
import com.example.management.config.token.TokenType;
import com.example.management.dto.user.AuthenticationResponse;
import com.example.management.dto.user.UserResponseDTO;
import com.example.management.dto.user.request.AuthenticationRequest;
import com.example.management.entity.appointment.Appointment;
import com.example.management.entity.treatment.Treatment;
import com.example.management.entity.user.Authority;
import com.example.management.entity.user.User;
import com.example.management.exception.CustomException;
import com.example.management.repository.appointment.AppointmentRepository;
import com.example.management.repository.treatment.TreatmentRepository;
import com.example.management.repository.user.UserRepository;
import com.example.management.service.user.user.AuthorityService;
import com.example.management.service.user.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityService authService;

    @Autowired
    private final AppointmentRepository appointmentRepository;
    @Autowired
    private final TreatmentRepository treatmentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;


    @Override
    public User save(UserResponseDTO userResponseDTO) {
        if (!userRepository.existsByUsername(userResponseDTO.getUsername())){
            User newUser = new User();
            newUser.setUsername(userResponseDTO.getUsername());
            newUser.setPassword(passwordEncoder.encode(userResponseDTO.getPassword()));
            newUser.setRole(userResponseDTO.getRole());
            List<Authority> authorities = authService.findByName(userResponseDTO.getRole());
            newUser.setAuthorities(authorities);
            userRepository.save(newUser);
            return newUser;
        }else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }



    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();

        // استرجاع الرول (Role) من اليوزر (User)
        String userRole = user.getAuthorities().stream()
                .findFirst()
                .map(authority -> authority.getAuthority())
                .orElse("ROLE_USER");

        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
//        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .role(userRole)
                .id(user.getId())  // تعيين الإيدي
                .username(user.getUsername())  // تعيين اسم المستخدم
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = TokenEntity.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }


    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void deleteUserById(Long userId) {
        // العثور على جميع المواعيد المرتبطة بالمستخدم
        List<Appointment> appointments =
                appointmentRepository.findByDoctorIdOrNurseIdOrPatientIdOrHospitalId(userId, userId, userId,userId);

        List<Treatment> treatments =
                treatmentRepository.findByDoctorIdOrNurseIdOrPatientIdOrMedicinesId(userId, userId, userId,userId);

        treatmentRepository.deleteAll(treatments);

        // حذف المواعيد المرتبطة بالمستخدم
        appointmentRepository.deleteAll(appointments);

        // حذف المستخدم بعد حذف المواعيد
        userRepository.deleteById(userId);

    }



    @Override
    public User findByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.orElse(null); // or handle differently based on your requirements
    }


}
