package com.example.management.service.user.user.impl;

import com.example.management.entity.user.Authority;
import com.example.management.entity.user.UserRoleName;
import com.example.management.repository.user.AuthorityRepository;
import com.example.management.service.user.user.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;
    @Override
    public void save(UserRoleName userRoleName) {
        authorityRepository.saveAuth(userRoleName.toString());
    }

    @Override
    public List<Authority> findByName(String name) {
        Authority authority = getAuthority(name);
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authority);
        return authorities;
    }

    private Authority getAuthority(String name) {
        for(Authority authority : authorityRepository.findAll()) {
            if(authority.getAuthority().equals(name)) {
                return authority;
            }
        }
        return null;
    }



}

