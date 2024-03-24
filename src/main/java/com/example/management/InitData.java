package com.example.management;

import com.example.management.config.JwtService;
import com.example.management.dto.user.UserResponseDTO;
import com.example.management.entity.user.UserRoleName;
import com.example.management.service.user.user.impl.AuthorityServiceImpl;
import com.example.management.service.user.user.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.pmw.tinylog.Logger;


@Service
@AllArgsConstructor
public class InitData {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AuthorityServiceImpl authorityService;
    @Autowired
    private final JwtService jwtService;


    public void Init(){
        String username = "mehdi";
        String password = "nmili";
        if (userService.findAll().isEmpty()){
            authorityService.save(UserRoleName.ROLE_ADMIN);
            authorityService.save(UserRoleName.ROLE_PATIENT);
            authorityService.save(UserRoleName.ROLE_DOCTOR);
            authorityService.save(UserRoleName.ROLE_NURSES);
            authorityService.save(UserRoleName.ROLE_EMPLOYEE);
            UserResponseDTO adminUser = new UserResponseDTO(username, password, "ROLE_ADMIN");
            // Generate JWT token for the default admin user
            String jwtToken = jwtService.generateToken(adminUser.toUserEntity());
            Logger.info("Username: {0}\nPassword: {1}\nJWT Token: {2}", username, password, jwtToken);
            userService.save(adminUser);
        }
    }
}
