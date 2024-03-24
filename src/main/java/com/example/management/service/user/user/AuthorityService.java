package com.example.management.service.user.user;

import com.example.management.entity.user.Authority;
import com.example.management.entity.user.UserRoleName;

import java.util.List;

public interface AuthorityService {

    void save(UserRoleName userRoleName);


    List<Authority> findByName(String name);

}
